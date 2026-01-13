package com.tcs.BankingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.BankingSystem.bean.Account;
import com.tcs.BankingSystem.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository repo;

	

	public List<Account> getAll() {
		return repo.findAll();
	}

	public Account getById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public Account save(Account a) {
		return repo.save(a);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
