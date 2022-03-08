package com.expensetracker.repository;


import com.expensetracker.entity.TransactionEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionsRepo extends JpaRepository<TransactionEnt, Integer> {

TransactionEnt findById(int transaction_no);
}
