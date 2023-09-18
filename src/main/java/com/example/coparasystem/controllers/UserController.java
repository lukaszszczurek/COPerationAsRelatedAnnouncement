package com.example.coparasystem.controllers;

import com.example.coparasystem.models.LoftModel;
import com.example.coparasystem.services.LoftService;
import com.example.coparasystem.services.UserService;
import com.example.coparasystem.models.UserModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserService userService;
    private final LoftService loftService;

    public UserController(UserService userService, LoftService loftService) {
        this.userService = userService;
        this.loftService = loftService;
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

    @GetMapping("/lofts/{email}")
    public List<LoftModel> getAllUserLofts (@PathVariable String email) throws Exception {
        Optional<UserModel> user = userService.findByEmail(email);
        if(!user.isPresent()){
            throw  new Exception("User not found");
        }

        ObjectId userId =user.get().getId();
        List<ObjectId> loftIds =  user.get().getLofts();
        if (loftIds == null) {
            throw new Exception("User has no lofts");
        }

        List<LoftModel> loftData = loftIds.stream()
                .map(x -> {
                    try {
                        return loftService.getLoftById(x);
                    } catch (Exception e) {
                        throw new RuntimeException
                                ("Service error cannot find service that user is member" + e);
                    }
                }).collect(Collectors.toList());

        return loftData;

        }
}

