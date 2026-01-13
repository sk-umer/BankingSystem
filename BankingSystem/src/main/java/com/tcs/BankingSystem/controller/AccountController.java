package com.tcs.BankingSystem.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.tcs.BankingSystem.service.AccountService;
import com.tcs.BankingSystem.bean.Account;
import java.util.List;

@RestController
public class AccountController {

	@Autowired
	private AccountService service;

	@GetMapping("/getallaccounts")
	public ResponseEntity<List<Account>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/getaccount/{id}")
	public ResponseEntity<Account> getById(@PathVariable Long id) {
		Account a = service.getById(id);
		return a != null ? ResponseEntity.ok(a) : ResponseEntity.notFound().build();
	}

	@PostMapping("/saveaccount")
	public ResponseEntity<String> create(@Valid @RequestBody Account a) {
		service.save(a);
		return ResponseEntity.ok("Account successfully created");
	}

	@PutMapping("/updateaccount/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody Account a) {
		a.setId(id);
		service.save(a);
		return ResponseEntity.ok("Account successfully updated");
	}

	@DeleteMapping("/deleteaccount/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok("Account successfully deleted");
	}
}
