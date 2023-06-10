package com.example.coparasystem.auth;

import com.example.coparasystem.models.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping ("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UserModel request
    ) {
        return  ResponseEntity.ok(authenticationService.register(request));
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
      return ResponseEntity.ok(authenticationService.authenticate(request));
    }




}
