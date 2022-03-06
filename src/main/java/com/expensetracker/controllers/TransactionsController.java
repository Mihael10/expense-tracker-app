package com.expensetracker.controllers;


import com.expensetracker.entity.TransactionEnt;

import com.expensetracker.entity.UserEnt;
import com.expensetracker.repository.TransactionsRepo;
import com.expensetracker.repository.UserRepo;
import com.expensetracker.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class TransactionsController {

    private final UserRepo userRepo;
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


   @PutMapping("/{user_id}/transactions/{transaction_no}")
    UserEnt showTransactions(@PathVariable int user_id,
                                    @PathVariable int transaction_no){
        UserEnt user = userRepo.getOne(user_id);
        TransactionService transaction = (TransactionService) transactionsRepo.getOne(transaction_no);
        transaction.showTransaction(user);
        return userRepo.save(user);
   }

}
