package com.expensetracker.service;


import com.expensetracker.entity.TransactionEnt;
import com.expensetracker.entity.UserEnt;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface TransactionService {


 TransactionEnt saveTransaction(TransactionEnt transaction);



}
