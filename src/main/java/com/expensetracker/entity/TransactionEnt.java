package com.expensetracker.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@ToString
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transactions")
public class TransactionEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer transaction_no;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "income")
    private LocalDate date;

    @Column(name = "category")
    private String category;

    @Column(name = "amount_expense")
    private String amount_expense;

}
