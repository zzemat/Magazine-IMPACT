package magazin.server.service.serviceImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import magazin.server.entity.Profile;
import magazin.server.entity.User;
import magazin.server.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.accessTokenExpirationMs}")
    private int jwtAccessExpirationMs;

    @Value("${jwt.refreshTokenExpirationMs}")
    private int jwtRefreshExpirationMs;

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public JwtUtils(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    public String generateAccessToken(Authentication authentication) {
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        return generateToken(userPrincipal, jwtAccessExpirationMs);
    }

    public String generateRefreshToken(Authentication authentication) {
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        return generateToken(userPrincipal, jwtRefreshExpirationMs);
    }

    private String generateToken(UserDetailsImpl userPrincipal, int expirationMs) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", userPrincipal.getEmail());
        claims.put("roles", userPrincipal.getAuthorities());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(String.valueOf(userPrincipal.getId()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean validateJwtToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().get("email", String.class);
    }

    public Long getUserIdFromToken(String token) {
        return Long.valueOf(Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject());
    }

    public String hashRefreshToken(String refreshToken) {
        return passwordEncoder.encode(refreshToken);
    }

    public boolean validateRefreshToken(String rawRefreshToken, String hashedRefreshToken) {
        return passwordEncoder.matches(rawRefreshToken, hashedRefreshToken);
    }

    public boolean isRefreshToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
            return claims.getExpiration().getTime() > System.currentTimeMillis() + jwtAccessExpirationMs;
        } catch (Exception e) {
            return false;
        }
    }
    public String getEmailFromToken(String token) {
        return getClaimsFromToken(token).get("email").toString();
    }
    public Claims getClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
    }

    public Profile getProfile(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return null;
        }

        String token = authorizationHeader.substring(7);
        Long userId = this.getUserIdFromToken(token);
        User userTemp = userService.getUserById(userId);

        return userTemp.getProfile();
    }

}
