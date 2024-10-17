package com.yourname.skillsharehub.controller;

import com.yourname.skillsharehub.model.Role;
import com.yourname.skillsharehub.model.Role.RoleName;
import com.yourname.skillsharehub.model.User;
import com.yourname.skillsharehub.payload.JwtAuthenticationResponse;
import com.yourname.skillsharehub.payload.LoginRequest;
import com.yourname.skillsharehub.payload.SignUpRequest;
import com.yourname.skillsharehub.repository.RoleRepository;
import com.yourname.skillsharehub.repository.UserRepository;
import com.yourname.skillsharehub.security.jwt.JwtTokenProvider;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    /**
     * Authenticates a user and returns a JWT token.
     *
     * @param loginRequest The login request containing email and password.
     * @return JWT Authentication Response.
     */
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        // Set the authentication in the security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generate JWT token
        String jwt = tokenProvider.generateToken(authentication);

        // Return the JWT in the response using the builder
        JwtAuthenticationResponse jwtResponse = JwtAuthenticationResponse.builder()
                .accessToken(jwt)
                .tokenType("Bearer")
                .build();

        return ResponseEntity.ok(jwtResponse);
    }

    /**
     * Registers a new user.
     *
     * @param signUpRequest The signup request containing user details.
     * @return Success message.
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse(false, "Email Address already in use!"));
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

        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(true, "User registered successfully"));
    }

    // Inner class for API responses

    @Setter
    @Getter
    public static class ApiResponse {
        // Getters and Setters
        private Boolean success;
        private String message;

        public ApiResponse(Boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }
}
