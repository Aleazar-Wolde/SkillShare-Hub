// src/main/java/com/yourname/skillsharehub/service/UserService.java
package com.yourname.skillsharehub.service;

import com.yourname.skillsharehub.exception.ResourceNotFoundException;
import com.yourname.skillsharehub.model.Role;
import com.yourname.skillsharehub.model.Role.RoleName;
import com.yourname.skillsharehub.model.User;
import com.yourname.skillsharehub.payload.SignUpRequest;
import com.yourname.skillsharehub.repository.RoleRepository;
import com.yourname.skillsharehub.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User registerUser(SignUpRequest signUpRequest) {
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new RuntimeException("Email Address already in use!");
        }

        // Creating user's account
        User user = User.builder()
                .name(signUpRequest.getName())
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .build();

        Set<Role> roles = new HashSet<>();

        // Assign ROLE_USER by default
        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("User Role not set."));
        roles.add(userRole);

        user.setRoles(roles);

        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User", "email", email));
    }


    public User updateUser(String email, User updatedUser) {
        User user = getUserByEmail(email);
        user.setName(updatedUser.getName());
        // Update other fields as necessary
        return userRepository.save(user);
    }

    // Additional user-related methods can be added here
}
