package com.example.coparasystem.auth;

import com.example.coparasystem.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String password;
    private Role role;

}
