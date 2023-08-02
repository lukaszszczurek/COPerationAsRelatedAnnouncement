package com.example.coparasystem.auth;

import com.example.coparasystem.Role;
import com.example.coparasystem.models.UserModel;
import com.example.coparasystem.UserRepository;
import com.example.coparasystem.services.UserService;
import com.example.coparasystem.config.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    private final UserService userService;
    public AuthenticationResponse register(UserModel request) {
        if(request.getEmail() == null || request.getEmail().isEmpty() || userService.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email is required");
        }
        var user = UserModel.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();


        userRepository.save(user);
        System.out.println("User saved = " + user);
        var jwtToken = jwtService.generateToken(user);
        System.out.println("jwtToken = " + jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        System.out.println("haslo");
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        System.out.println("pip");
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        System.out.println("User logged = " + user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }
}
