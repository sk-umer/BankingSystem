package com.tcs.BankingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.BankingSystem.bean.Employee;
import com.tcs.BankingSystem.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;

	

	public List<Employee> getAll() {
		return repo.findAll();
	}

	public Employee getById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public Employee save(Employee e) {
		return repo.save(e);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
