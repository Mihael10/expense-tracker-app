package com.expensetracker.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserTransactionsDto {

    private String username;
    private int transaction_no;
    public LocalDate date;
    public String description;
    public String amount;

}
