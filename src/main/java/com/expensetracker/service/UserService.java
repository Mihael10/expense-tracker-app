package com.expensetracker.service;

import com.expensetracker.DTO.UserTransactionDto;
import com.expensetracker.entity.UserEnt;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface UserService {

    UserEnt saveUser(UserEnt user);
    UserEnt getUser(String username);
    UserTransactionDto getTransactionsByUser(int user_id);


}
