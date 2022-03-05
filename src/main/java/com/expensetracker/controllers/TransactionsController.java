package com.expensetracker.controllers;


import com.expensetracker.DTO.UserTransactionsDto;
import com.expensetracker.entity.TransactionEnt;

import com.expensetracker.repository.TransactionsRepo;
import com.expensetracker.service.TransactionService;
import com.expensetracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transaction")
public class TransactionsController {

    private final TransactionsRepo transactionsRepo;
    private final TransactionService transactionsService;

    @GetMapping("/get-all-transactions")
    public List<TransactionEnt> getAllTransactions(){
        List<TransactionEnt> allTransactions = transactionsRepo.findAll();
        return allTransactions;

    }
    @PostMapping("/new/transaction")
    public TransactionEnt newTransaction (@RequestBody TransactionEnt transactionEnt) {

        TransactionEnt newTransaction = transactionsRepo.save(new TransactionEnt());

        return newTransaction;
    }

    @PostMapping
    public ResponseEntity<?> getTransactionsByUsername(@RequestBody UserTransactionsDto form){
        return null;
    }
}
