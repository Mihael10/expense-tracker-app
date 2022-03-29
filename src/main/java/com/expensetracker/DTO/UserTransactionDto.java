package com.expensetracker.DTO;


import lombok.Data;


import java.util.Date;


@Data
public class UserTransactionDto {

    private String username;
    private int transaction_no;
    private String description;
    private String category;
    private double amount_expense;
    private Date date;
}
