package com.example.coparasystem;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
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
    private MongoTemplate mongoTemplate;
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
    @PutMapping(path = "{id}")
    public void updateUserPhoto(@PathVariable("id") ObjectId id, @RequestParam String photoUrl){

        userService.UpdateUserProfilePicture(id,photoUrl);
        System.out.printf(id +" } + id");
    }


}
