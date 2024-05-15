package com.javasoft.eterno.controller.auth;

import com.javasoft.eterno.dto.UserDTO;
import com.javasoft.eterno.security.AuthenticationRequest;
import com.javasoft.eterno.security.AuthenticationResponse;
import com.javasoft.eterno.security.RegisterRequest;

import com.javasoft.eterno.security.securityService.AuthenticationService;
import com.javasoft.eterno.security.securityService.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UserDTO userDTO
    ){
        return ResponseEntity.ok(authenticationService.register(userDTO));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
