package com.expensetracker.service;


public interface TransactionService {

void showTransactions(String username, int transaction_no,
                      String description, int amount_expense, String category);
}
