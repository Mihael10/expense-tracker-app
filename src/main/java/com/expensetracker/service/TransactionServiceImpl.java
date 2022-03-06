package com.expensetracker.service;

import com.expensetracker.entity.TransactionEnt;
import com.expensetracker.entity.UserEnt;
import com.expensetracker.repository.TransactionsRepo;
import com.expensetracker.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Transactional @Slf4j @RequiredArgsConstructor @Service
public class TransactionServiceImpl implements TransactionService{

    private final UserRepo userRepo;
    private final TransactionsRepo transactionsRepo;
    private UserEnt userEnt;




    @Override
    public TransactionEnt saveTransaction(TransactionEnt transaction) {
        TransactionEnt transactionEnt = new TransactionEnt();

        transactionEnt.setDescription(transactionEnt.getDescription());
        transactionEnt.setDate(transaction.getDate());
        transactionEnt.setAmount_expense(transaction.getAmount_expense());
        transactionEnt.setCategory(transaction.getCategory());

        return transactionsRepo.save(transactionEnt);
    }
}
