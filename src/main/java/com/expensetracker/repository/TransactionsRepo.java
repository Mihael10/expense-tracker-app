package com.expensetracker.repository;


import com.expensetracker.entity.TransactionEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionsRepo extends JpaRepository<TransactionEnt, Integer> {


}
