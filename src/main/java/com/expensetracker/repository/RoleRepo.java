package com.expensetracker.repository;

import com.expensetracker.entity.RoleEnt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<RoleEnt, Integer> {

    RoleEnt findByName (String name);
}
