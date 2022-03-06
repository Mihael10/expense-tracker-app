package com.expensetracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.hibernate.sql.InFragment.NOT_NULL;

@ToString
@RequiredArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @JsonIgnore
    @OneToMany
    private Set<TransactionEnt> userTransactions = new HashSet<>();

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;



}