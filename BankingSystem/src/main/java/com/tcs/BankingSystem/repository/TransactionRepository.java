package com.tcs.BankingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.BankingSystem.bean.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	
}