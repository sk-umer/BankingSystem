package com.tcs.BankingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.BankingSystem.bean.Loan;
import com.tcs.BankingSystem.repository.LoanRepository;

@Service
public class LoanService {
	
	@Autowired
	private LoanRepository repo;

	
	public List<Loan> getAll() {
		return repo.findAll();
	}

	public Loan getById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public Loan save(Loan l) {
		return repo.save(l);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
