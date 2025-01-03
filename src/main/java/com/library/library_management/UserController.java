package com.library.library_management;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public ResponseEntity<String> user(Authentication auth) {
        if (auth == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No authenticated user found");
        }

        String principal = auth.getPrincipal().toString();
        return ResponseEntity.ok("Principal: " + principal);
    }

}

