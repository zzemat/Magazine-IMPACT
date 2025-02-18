package magazin.server;


import magazin.server.entity.Role;
import magazin.server.entity.User;
import magazin.server.repository.RoleRepository;
import magazin.server.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (userRepository.findByUsername("said").isEmpty()) {
            User admin = new User();
            admin.setUsername("said");
            admin.setEmail("s@gmail.com");
            admin.setPassword(passwordEncoder.encode("2002"));
            admin.setEnabled(true);
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_ADMIN").get());
            admin.setRoles(roles);
            userRepository.save(admin);
            System.out.println("Utilisateur admin créé !");
        }


    }
    }
