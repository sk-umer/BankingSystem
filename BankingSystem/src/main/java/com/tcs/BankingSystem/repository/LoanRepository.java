package com.tcs.BankingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.BankingSystem.bean.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
	
}