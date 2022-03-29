package com.expensetracker.service;

import com.expensetracker.entity.TransactionEnt;
import com.expensetracker.entity.UserEnt;
import com.expensetracker.repository.TransactionsRepo;
import com.expensetracker.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Transactional @Slf4j @RequiredArgsConstructor @Service
public class TransactionServiceImpl implements TransactionService {


    private final TransactionsRepo transactionsRepo;


    @Override
    public TransactionEnt saveTransaction(@RequestBody TransactionEnt transaction) {

        //TransactionEnt transactionEnt = new TransactionEnt();

        transaction.setDescription(transaction.getDescription());
        transaction.setDate(transaction.getDate());
        transaction.setAmount_expense(transaction.getAmount_expense());
        transaction.setCategory(transaction.getCategory());
        log.info("Saving transaction..{} " + transaction);
        return transactionsRepo.save(transaction);
    }

}

