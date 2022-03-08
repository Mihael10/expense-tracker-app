package com.expensetracker.DTO;

import com.expensetracker.entity.TransactionEnt;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class UserTransactionDto {

    private String username;
    private String description;
    private String category;
    private double amount_expense;
    private Date date;
}
