package com.expensetracker.service;

import com.expensetracker.entity.TransactionEnt;
import com.expensetracker.entity.UserEnt;

import java.util.Collection;


public interface UserService {

    UserEnt saveUser(UserEnt user);
    UserEnt getUser(String username);
    TransactionEnt getTransactionsByUser(String username);


}
