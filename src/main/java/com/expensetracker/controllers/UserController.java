package com.expensetracker.controllers;



import com.expensetracker.entity.UserEnt;

import com.expensetracker.repository.UserRepo;
import com.expensetracker.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class UserController {


    private final UserRepo userRepo;

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;



    @GetMapping("/get/{user_id}")
    public UserEnt getUserById(@PathVariable(value = "user_id") int user_id) {
        UserEnt userEnt = userRepo.findById(user_id).get();

        return userEnt;
    }


    @PostMapping("/save/user")
    public ResponseEntity<UserEnt> registerUser(@RequestBody UserEnt user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/save/user").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }


    @PutMapping("/update/{user_id}")
    public ResponseEntity<UserEnt> updateUser(@PathVariable(value = "user_id") int user_id,
                                              @RequestBody UserEnt userEnt) {
        UserEnt user = userRepo.findById(user_id).get();

        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        final UserEnt updatedUser = userRepo.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{user_id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "user_id") int user_id) {
        UserEnt user = userRepo.findById(user_id).get();

        userRepo.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
