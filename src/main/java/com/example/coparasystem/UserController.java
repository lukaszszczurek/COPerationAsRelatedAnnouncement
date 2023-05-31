package com.example.coparasystem;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private MongoTemplate mongoTemplate;

    @GetMapping()
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return new ResponseEntity<List<UserModel>>(userService.allUsers(), HttpStatus.OK);
    }



    @PostMapping
    public void createNewUser(@RequestBody UserModel userModel) {
        userService.createUser(userModel);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Optional<UserModel>> getUserModel(@PathVariable String email) {
        return new ResponseEntity<Optional<UserModel>>(userService.findByEmail(email), HttpStatus.OK);
    }

    @PutMapping(path = "{id}")
    public void updateUserPhoto(@PathVariable("id") ObjectId id, @RequestParam String photoUrl) {
        userService.UpdateUserProfilePicture(id, photoUrl);
        System.out.printf(id + " } + id");
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/test2")
    public String test2() {
        return "test2";
    }

    @CrossOrigin
    @PostMapping("/login")
    public boolean handleLogin(@RequestBody UserModel userModel) {

        Optional<UserModel> user = userService.findByEmail(userModel.getEmail());
        if (user.isPresent()) {
            UserModel userFromBase = user.get();
            System.out.println(userFromBase);
            if (Objects.equals(userFromBase.getPassword(), userModel.getPassword())) {
                return true;
            }
        } else {
            System.out.println("User doesn't exist");
        }
        System.out.println(userModel);
        return true;
    }


//    @PostMapping("/loginUsingJWT")
//    public ResponseEntity<?> handleLoginUsingJWT(@RequestBody UserModel userModel) {
//
//        try{
//            Authentication authentication = auth.authenticate(
//                    new UsernamePasswordAuthenticationToken(userModel.getEmail(), userModel.getPassword())
//            );
//        }
//
//
//        String token = userService.loginUsingJWT(userModel);
//
//        return new ResponseEntity<String>(token, HttpStatus.OK);
//
//
//    }



//    @PostMapping("/login")
//    public ResponseEntity<?> handleLogin(@RequestBody LoginForm loginForm) {
//        // Obsługa logiki uwierzytelniania i zwracanie odpowiedzi
//    }

}

