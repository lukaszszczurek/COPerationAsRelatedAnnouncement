package com.example.coparasystem.auth;

import com.example.coparasystem.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping ("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UserModel request
    ) {
        System.out.println("request (User in Controller)= " + request);
        return  ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        System.out.println("request (Auth in Controller)= " + request);
      return ResponseEntity.ok(authenticationService.authenticate(request));
    }




}
