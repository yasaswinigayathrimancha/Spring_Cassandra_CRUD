package com.example.newone.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.newone.entity.User;
import com.example.newone.repo.UserRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getall")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") UUID id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        UUID id = UUID.randomUUID();
        user.setId(id);
        userRepository.save(user);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") UUID id, @RequestBody User user) {
        user.setId(id);
        userRepository.save(user);
        return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") UUID id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

    
}
