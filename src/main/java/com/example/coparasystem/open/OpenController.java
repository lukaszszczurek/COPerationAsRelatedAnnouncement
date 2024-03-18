package com.example.coparasystem.open;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/1")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class OpenController {
    @GetMapping()
    public String a() {
        return "Public endpoint";
    }
}
