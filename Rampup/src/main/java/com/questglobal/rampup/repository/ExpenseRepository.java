package com.questglobal.rampup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.questglobal.rampup.model.Expense;
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

}
