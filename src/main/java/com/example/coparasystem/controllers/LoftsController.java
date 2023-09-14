package com.example.coparasystem.controllers;

import com.example.coparasystem.models.LoftModel;
import com.example.coparasystem.services.LoftService;
import com.example.coparasystem.services.UserService;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "Bearer")
@RequestMapping("/api/v1/lofts")
public class LoftsController {
    // get loft by id

    private final LoftService loftService;
    private final UserService userService;

    @GetMapping()
    public String e4(){
        System.out.println("sdsadd");
        return "e4";
    }

    public LoftsController(LoftService loftService, UserService userService)
    {
        this.loftService = loftService;
        this.userService = userService;
    }

    public LoftModel getLoftById(ObjectId loftId) throws Exception
    {
        return loftService.getLoftById(loftId);
    }


    @PostMapping("/create/{userEmail}")
    public void createNewLoft(@RequestBody @NotNull LoftModel loftModel, @PathVariable("userEmail") String userEmail) throws Exception {
        var name = loftModel.getName();
       if(loftService.getLoftByName(name).isPresent()){
           System.out.println("Loft with this name already exists");
           return;}
        System.out.println("Creating new loft...");
       var OptionalUser = userService.findByEmail(userEmail);
       if(!OptionalUser.isPresent()) {
           System.out.println("User with this email does not exist");
           return;
       }
        var userId = OptionalUser.get().getId();
        loftService.createNewLoft(loftModel);
        loftModel.setOwnerId(userId);
        loftModel.getUserIds().add(userId);
        System.out.println("Loft created");

    }



}
