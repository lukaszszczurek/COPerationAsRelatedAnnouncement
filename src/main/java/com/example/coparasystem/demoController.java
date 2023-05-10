package com.example.coparasystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/1")
public class demoController {

    @GetMapping
    public String demo() {
        return "Secure endpoint";
    }
}
