package com.expensetracker.service;

import com.expensetracker.repository.TransactionsRepo;
import com.expensetracker.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;



@Transactional @Slf4j @RequiredArgsConstructor @Service
public class TransactionServiceImpl implements TransactionService{

    private final UserRepo userRepo;
    private final TransactionsRepo transactionRepo;

    @Override
    public void showTransactions(String username, int transaction_no,
                                 String description, int amount_expense, String category) {

    }
}
