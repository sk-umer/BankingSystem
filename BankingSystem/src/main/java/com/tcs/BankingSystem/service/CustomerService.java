package com.tcs.BankingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.BankingSystem.bean.Customer;
import com.tcs.BankingSystem.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repo;


	public List<Customer> getAll() {
		return repo.findAll();
	}

	public Customer getById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public Customer save(Customer c) {
		return repo.save(c);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
