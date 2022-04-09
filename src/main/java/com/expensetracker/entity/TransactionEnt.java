package com.expensetracker.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.persistence.*;

import java.util.Date;


@ToString
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transactions")
public class TransactionEnt  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transaction_no;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date")
    private Date date;

    @Column(name = "category")
    private String category;

    @Column(name = "amount_expense")
    private double amount_expense;
    
    @Column(name  = "description")
    private String description;

   @ManyToOne(fetch = FetchType.EAGER)
    @JsonDeserialize
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private UserEnt userEnt;



}
