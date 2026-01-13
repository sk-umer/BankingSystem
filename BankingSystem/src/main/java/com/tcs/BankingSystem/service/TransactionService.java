package com.tcs.BankingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.BankingSystem.bean.Transaction;
import com.tcs.BankingSystem.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository repo;

	
	public List<Transaction> getAll() {
		return repo.findAll();
	}

	public Transaction getById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public Transaction save(Transaction t) {
		return repo.save(t);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
