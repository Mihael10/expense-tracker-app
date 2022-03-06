package com.expensetracker.service;

import com.expensetracker.entity.TransactionEnt;
import com.expensetracker.entity.UserEnt;
import com.expensetracker.repository.TransactionsRepo;
import com.expensetracker.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Transactional @Slf4j @RequiredArgsConstructor @Service
public class TransactionServiceImpl implements TransactionService{


    private UserEnt userEnt;


    public void showTransaction(UserEnt user) {
        this.userEnt = user;
    }
}
