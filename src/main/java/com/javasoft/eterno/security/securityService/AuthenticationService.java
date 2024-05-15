package com.javasoft.eterno.security.securityService;

import com.javasoft.eterno.dto.UserDTO;
import com.javasoft.eterno.entity.User;
import com.javasoft.eterno.repository.UserRepository;
import com.javasoft.eterno.security.AuthenticationRequest;
import com.javasoft.eterno.security.AuthenticationResponse;
import com.javasoft.eterno.security.RegisterRequest;
import com.javasoft.eterno.service.UserService;
import com.javasoft.eterno.util.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import static com.javasoft.eterno.util.Role.USER;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private  final JwtService jwtService;
    private  final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(UserDTO userDTO) {
        User user = new User(userDTO.getFirstname(), userDTO.getLastname(), userDTO.getEmail(), userDTO.getPassword(), USER);
        userService.save(user);
        var jwtToken  = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userService.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken  = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
