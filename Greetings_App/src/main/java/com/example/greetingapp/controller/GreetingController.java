package com.example.greetingapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

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