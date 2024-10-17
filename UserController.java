// src/main/java/com/yourname/skillsharehub/controller/UserController.java
package com.yourname.skillsharehub.controller;

import com.yourname.skillsharehub.model.User;
import com.yourname.skillsharehub.payload.ApiResponse;
import com.yourname.skillsharehub.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(Authentication authentication) {
        String email = authentication.getName();
        User user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/me")
    public ResponseEntity<?> updateCurrentUser(@Valid @RequestBody User updatedUser, Authentication authentication) {
        String email = authentication.getName();
        userService.updateUser(email, updatedUser);
        return ResponseEntity.ok(new ApiResponse(true, "User updated successfully"));
    }

    // Additional user-related endpoints can be added here
}
