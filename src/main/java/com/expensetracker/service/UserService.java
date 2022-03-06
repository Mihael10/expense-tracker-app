package com.expensetracker.service;

import com.expensetracker.entity.UserEnt;

import java.util.List;


public interface UserService {

    UserEnt saveUser(UserEnt user);
    UserEnt getUser(String username);


}
