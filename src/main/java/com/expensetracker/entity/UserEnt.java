package com.expensetracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;



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
    @OneToMany(fetch=FetchType.LAZY, targetEntity = TransactionEnt.class)
    private Set<TransactionEnt> userTransactions = new HashSet<>();

    @Column(name = "full_name")
    private String full_name;
    
    @NotNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Size(min=8)
    @Column(name = "password", nullable = false)
    private String password;



}