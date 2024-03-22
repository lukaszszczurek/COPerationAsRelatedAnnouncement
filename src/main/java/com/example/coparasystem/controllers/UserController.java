package com.example.coparasystem.controllers;

import com.example.coparasystem.models.LoftModel;
import com.example.coparasystem.services.UserService;
import com.example.coparasystem.models.UserModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

    @GetMapping()
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return new ResponseEntity<List<UserModel>>(userService.allUsers(), HttpStatus.OK);
    }

    @GetMapping("/lofts/{email}")
    public List<Optional<LoftModel>> getAllLofts(@PathVariable String email) {
        return userService.allLofts(email);
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

}

