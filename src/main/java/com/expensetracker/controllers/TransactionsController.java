package com.expensetracker.controllers;



import com.expensetracker.entity.TransactionEnt;


import com.expensetracker.repository.TransactionsRepo;

import com.expensetracker.service.TransactionService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class TransactionsController {


    private final TransactionsRepo transactionsRepo;
    private final TransactionService transactionsService;

    @GetMapping("/get-all-transactions")
    public List<TransactionEnt> getAllTransactions(){
        List<TransactionEnt> allTransactions = transactionsRepo.findAll();
        return allTransactions;

    }
    @PostMapping("/{username}/new-transaction")
    public TransactionEnt newTransaction (@RequestBody TransactionEnt transactionEnt,
                                          @PathVariable(value = "username")String username) {
        return transactionsService.saveTransaction(transactionEnt, username);
    }



   }


