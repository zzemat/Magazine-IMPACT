package magazin.server;

import magazin.server.entity.Role;
import magazin.server.entity.User;
import magazin.server.repository.RoleRepository;
import magazin.server.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        return args -> {
            // Vérifier si le rôle ADMIN existe, sinon le créer
            Role adminRole = roleRepository.findByName("ADMIN")
                    .orElseGet(() -> {
                        Role role = new Role();
                        role.setName("ADMIN");
                        return roleRepository.save(role);
                    });

            // Vérifier si un admin existe déjà
            if (userRepository.findByEmail("admin@gmail.com").isEmpty()) {
                User admin = new User();
                admin.setEmail("admin@gmail.com");
                admin.setPassword(passwordEncoder.encode("2002")); // Assurez-vous que le mot de passe est encodé
                admin.setUsername("admin");
                admin.setEnabled(true);
                admin.setRoles(Set.of(adminRole));

                userRepository.save(admin);
                System.out.println("Admin user created: admin@gmail.com / 2002");
            }
        };
    }
}
