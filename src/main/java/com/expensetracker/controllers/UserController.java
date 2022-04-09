package com.expensetracker.controllers;




import com.expensetracker.entity.TransactionEnt;
import com.expensetracker.entity.UserEnt;

import com.expensetracker.repository.TransactionsRepo;
import com.expensetracker.repository.UserRepo;
import com.expensetracker.service.UserService;


import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.MapBindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.ResultSet;
import java.util.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class UserController {

    private final TransactionsRepo transactionRepository;
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
    public ResponseEntity<UserEnt> updateUser(@PathVariable int user_id,
                                              @RequestBody UserEnt userEnt) {

             userRepo.findById(user_id)
                    .map(user -> {
                        user.setFull_name(userEnt.getFull_name());
                        user.setUsername(userEnt.getUsername());
                        user.setEmail(userEnt.getEmail());
                        user.setPassword(passwordEncoder.encode(user.getPassword()));
                        return userRepo.save(user);
                    });

                        return ResponseEntity.ok(userEnt);
        }


    @DeleteMapping("/delete/{user_id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "user_id") int user_id) {
        UserEnt user = userRepo.findById(user_id).get();

        userRepo.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/{username}/transaction")
    public TransactionEnt getUserTransactions(@PathVariable(value = "username")String username){

        return  userService.getTransactionsByUser(username);
    }

}






