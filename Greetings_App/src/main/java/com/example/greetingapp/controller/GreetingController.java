package com.example.greetingapp.controller;

import com.example.greetingapp.entity.Greeting;
import com.example.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("")
    public String greet(@RequestParam(required = false) String firstName,
                        @RequestParam(required = false) String lastName) {
        return greetingService.getGreeting(firstName, lastName);
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

    @PostMapping("/save")
    public ResponseEntity<Greeting> saveGreeting(@RequestBody String message) {
        Greeting savedGreeting = greetingService.saveGreeting(message);
        return ResponseEntity.ok(savedGreeting);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable Long id) {
        Greeting greeting = greetingService.findGreetingById(id);
        if (greeting != null) {
            return ResponseEntity.ok(greeting);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Greeting>> getAllGreetings() {
        List<Greeting> greetings = greetingService.getAllGreetings();
        return ResponseEntity.ok(greetings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Greeting> updateGreeting(@PathVariable Long id, @RequestBody String message) {
        Greeting updatedGreeting = greetingService.updateGreeting(id, message);
        if (updatedGreeting != null) {
            return ResponseEntity.ok(updatedGreeting);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        return ResponseEntity.noContent().build();
    }

}