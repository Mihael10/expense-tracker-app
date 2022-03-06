package com.expensetracker.service;


import com.expensetracker.entity.TransactionEnt;
import com.expensetracker.entity.UserEnt;

import java.time.LocalDate;

public interface TransactionService {


 TransactionEnt saveTransaction(TransactionEnt transaction);

}
