package com.expensetracker.service;

import com.expensetracker.entity.RoleEnt;
import com.expensetracker.entity.UserEnt;

import java.util.List;


public interface UserService {

    UserEnt saveUser(UserEnt user);
    UserEnt getUser(String username);
    RoleEnt saveRole(RoleEnt role);
    void addRoleToUser(String username, String roleName);
    List<UserEnt> getUsers();

}
