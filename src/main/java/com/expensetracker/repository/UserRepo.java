package com.expensetracker.repository;

import com.expensetracker.entity.UserEnt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEnt, Integer> {

    UserEnt findByUsername(String username);




    Arrays findBy();
}
