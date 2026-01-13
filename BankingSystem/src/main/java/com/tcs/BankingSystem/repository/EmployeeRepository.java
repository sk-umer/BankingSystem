package com.tcs.BankingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.BankingSystem.bean.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}