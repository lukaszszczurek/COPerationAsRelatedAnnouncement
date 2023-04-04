package com.example.coparasystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public ResponseEntity<List<UserModel>> getAllUsers(){
        return new ResponseEntity<List<UserModel>>(userService.allUsers(),HttpStatus.OK);
    }
    @PostMapping
    public void createNewUser(@RequestBody UserModel userModel){
        userService.createUser(userModel);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Optional<UserModel>> getUserModel(@PathVariable String email){
        return new ResponseEntity<Optional<UserModel>>(userService.findByEmail(email),HttpStatus.OK);
    }


}
