package com.example.coparasystem.controllers;

import com.example.coparasystem.models.LoftModel;
import com.example.coparasystem.services.LoftService;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "Bearer")
@RequestMapping("/api/v1/lofts")
public class LoftsController {
    // get loft by id

    private final LoftService loftService;

    @GetMapping()
    public String e4(){
        System.out.println("sdsadd");
        return "e4";
    }

    public LoftsController(LoftService loftService) {
        this.loftService = loftService;
    }

    @GetMapping("/id/{name}")
    public Optional<LoftModel> getLoftById(@PathVariable String name){
       try {
           System.out.println("123");


           return loftService.getLoftByName(name);
       }
       catch (Exception e)
       {
           System.out.println("Cant find with this ID exception");
           return Optional.empty();
       }
    }

    @GetMapping("/{email}")
    public Optional<LoftModel> getLoftByEmail(@PathVariable String email){
        try {
            return loftService.getLoftByEmail(email);
        }
        catch (Exception e){
            System.out.println("Cannot find loft with this email");
            return Optional.empty();
        }
    }
    @PostMapping
    public void createNewLoft(@RequestBody LoftModel loftModel){
        System.out.println("Creating new loft...");
        loftService.createNewLoft(loftModel);
        System.out.println("Loft created");
    }



}
