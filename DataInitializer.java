package com.yourname.skillsharehub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.yourname.skillsharehub.model.User;
import com.yourname.skillsharehub.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User adminUser = User.builder()
                    .name("Admin User")
                    .username("admin")
                    .email("admin@example.com")
                    .password(passwordEncoder.encode("password123"))
                    .build();
            userRepository.save(adminUser);
        }
    }
}
