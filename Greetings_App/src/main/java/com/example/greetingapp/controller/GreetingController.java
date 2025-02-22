package com.example.greetingapp.controller;

import com.example.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping
    public String getGreeting() {
        return "{\"message\": \"" + greetingService.getGreetingMessage() + "\"}";
    }

    @GetMapping("")
    public String greet() {
        return "Hello World!";
    }

    @PostMapping("")
    public String greetPost() {
        return "Hello World via POST!";
    }

    @PutMapping("")
    public String greetPut() {
        return "Hello World via PUT!";
    }

    @DeleteMapping("")
    public String greetDelete() {
        return "Hello World via DELETE!";
    }


}