package com.expensetracker.service;

import com.expensetracker.entity.UserEnt;
import com.expensetracker.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service @RequiredArgsConstructor @Slf4j @Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEnt saveUser(UserEnt user) {
        log.info("Saving new user: {}" + user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public UserEnt getUser(String username) {
        log.info("Getting user by username {} ", username);

        return userRepo.findByUsername(username);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEnt user = userRepo.findByUsername(username);
        if(user == null){
            log.error("Username not found!");
                throw new UsernameNotFoundException("Username not found");
        }else{
            log.info("User found {}", username);
        }
        user.setUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
