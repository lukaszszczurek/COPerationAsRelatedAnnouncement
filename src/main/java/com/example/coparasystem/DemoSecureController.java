package com.example.coparasystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/public")
public class DemoSecureController {

    @GetMapping
public String demo() {
        return "Public Endpoint";
    }
}
