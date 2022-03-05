package com.expensetracker.controllers;



import com.expensetracker.DTO.RoleToUserDto;
import com.expensetracker.entity.RoleEnt;
import com.expensetracker.entity.UserEnt;

import com.expensetracker.repository.UserRepo;
import com.expensetracker.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepo userRepo;

    private final UserService userService;


    @GetMapping("/all/users")
    public ResponseEntity<List<UserEnt>> getInAllUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/get-users/{id}")
    public UserEnt getUserById (@PathVariable(value = "id") int user_id)

    {
        UserEnt userEnt = userRepo.findById(user_id).get();

        return userEnt;
    }



    @PostMapping("/save/user")
    public ResponseEntity<UserEnt> registerUser (@RequestBody UserEnt user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/save/user").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/save/role")
    public ResponseEntity<RoleEnt> saveRole (@RequestBody RoleEnt role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/save/role").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser (@RequestBody RoleToUserDto form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<UserEnt> updateUser (@PathVariable(value = "id") int user_id,
                                                           @RequestBody UserEnt userEnt) {
        UserEnt user = userRepo.findById(user_id).get();

        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());

        final UserEnt updatedUser = userRepo.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete-users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") int user_id)
    {
        UserEnt user = userRepo.findById(user_id).get();

        userRepo.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
