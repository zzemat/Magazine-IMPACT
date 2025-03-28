package magazin.server.controller;

import magazin.server.entity.User;
import magazin.server.entity.Role;
import magazin.server.repository.UserRepository;
import magazin.server.repository.RoleRepository;
import magazin.server.service.serviceImpl.JwtUtils;
import magazin.server.service.serviceImpl.UserDetailsImpl;
import magazin.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public Map<String, String> authenticateUser(@RequestBody Map<String, String> request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.get("email"), request.get("password")));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String accessToken = jwtUtils.generateAccessToken(authentication);
            String refreshToken = jwtUtils.generateRefreshToken(authentication);

            User user = userRepository.findByEmail(request.get("email")).orElseThrow();
            user.setRefreshToken(passwordEncoder.encode(refreshToken));
            userRepository.save(user);

            Map<String, String> tokens = new HashMap<>();
            tokens.put("accessToken", accessToken);
            tokens.put("refreshToken", refreshToken);
            return tokens;

        } catch (BadCredentialsException e) {
            throw new RuntimeException("Email or password invalid");
        }
    }

    @PostMapping("/signup")
    public Map<String, String> registerUser(@RequestBody Map<String, String> request) {
        if (userRepository.existsByEmail(request.get("email"))) {
            throw new RuntimeException("Email is already in use");
        }

        User user = new User();
        user.setEmail(request.get("email"));
        user.setPassword(passwordEncoder.encode(request.get("password")));
        user.setUsername(request.get("username"));
        Role userRole = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        user.getRoles().add(userRole);
        User createdUser = userService.createUser(user);
        userService.createProfileForUser(createdUser.getId());


        Map<String, String> response = new HashMap<>();
        response.put("message", "User registered successfully");
        return response;
    }


    @PostMapping("/refresh")
    public Map<String, String> refreshToken(@RequestHeader("Authorization") String refreshTokenHeader) {
        String refreshToken = refreshTokenHeader.replace("Bearer ", "");

        if (!jwtUtils.isRefreshToken(refreshToken)) {
            throw new RuntimeException("Invalid token type: Expected refresh token");
        }

        String email = jwtUtils.getEmailFromToken(refreshToken);
        User user = userRepository.findByEmail(email).orElseThrow();

        if (!passwordEncoder.matches(refreshToken, user.getRefreshToken())) {
            throw new RuntimeException("Invalid refresh token");
        }

        UserDetailsImpl userDetails = UserDetailsImpl.build(user);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        String newAccessToken = jwtUtils.generateAccessToken(authentication);
        String newRefreshToken = jwtUtils.generateRefreshToken(authentication);

        user.setRefreshToken(passwordEncoder.encode(newRefreshToken));
        userRepository.save(user);

        Map<String, String> tokens = new HashMap<>();
        tokens.put("accessToken", newAccessToken);
        tokens.put("refreshToken", newRefreshToken);
        return tokens;
    }

    @PostMapping("/logout")
    public Map<String, String> logout(@RequestHeader("Authorization") String accessTokenHeader) {
        String accessToken = accessTokenHeader.replace("Bearer ", "");
        String email = jwtUtils.getEmailFromToken(accessToken);

        User user = userRepository.findByEmail(email).orElseThrow();
        user.setRefreshToken(null);
        userRepository.save(user);

        SecurityContextHolder.clearContext();

        Map<String, String> response = new HashMap<>();
        response.put("message", "Logged out successfully");
        return response;
    }
}
