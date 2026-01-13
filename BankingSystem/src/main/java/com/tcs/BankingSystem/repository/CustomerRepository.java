package com.tcs.BankingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.BankingSystem.bean.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}