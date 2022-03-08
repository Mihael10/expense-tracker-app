package com.expensetracker.controllers;



import com.expensetracker.DTO.UserTransactionDto;
import com.expensetracker.entity.UserEnt;

import com.expensetracker.repository.UserRepo;
import com.expensetracker.service.UserService;


import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class UserController {


    private final UserRepo userRepo;

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    @GetMapping("/get/{user_id}")
    public UserEnt getUserById(@PathVariable(value = "user_id") int user_id) {
        UserEnt userEnt = userRepo.findById(user_id).orElseThrow(IllegalArgumentException::new);
        userService.getUser(userEnt.getUsername());
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

        user.setFull_name(user.getFull_name());
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

    @GetMapping("/{user_id}-transactions")
    public ResponseEntity<UserTransactionDto> getAllUserTransactions(@PathVariable(value = "user_id")
                                                                     int user_id) {
        UserEnt user = userRepo.getById(user_id);
        ModelMapper modelMapper = new ModelMapper();

        // convert entity to DTO
        UserTransactionDto userResponse = modelMapper.map(user, UserTransactionDto.class);
        userResponse.setCategory(userResponse.getCategory());
        userResponse.setDescription(userResponse.getDescription());
        userResponse.setAmount_expense(userResponse.getAmount_expense());
        userResponse.setUsername(userResponse.getUsername());
        userResponse.setDate(userResponse.getDate());
        return  ResponseEntity.ok().body(userResponse);
    }
}






