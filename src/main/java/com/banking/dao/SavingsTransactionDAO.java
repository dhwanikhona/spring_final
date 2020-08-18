package com.banking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.model.SavingsTransaction;


public interface SavingsTransactionDAO extends JpaRepository<SavingsTransaction, Integer> {

	
    List<SavingsTransaction> findAll();
}
