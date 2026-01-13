package com.tcs.BankingSystem.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.tcs.BankingSystem.service.TransactionService;
import com.tcs.BankingSystem.bean.Transaction;
import java.util.List;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService service;

	@GetMapping("/getalltransactions")
	public ResponseEntity<List<Transaction>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/gettransaction/{id}")
	public ResponseEntity<Transaction> getById(@PathVariable Long id) {
		Transaction t = service.getById(id);
		return t != null ? ResponseEntity.ok(t) : ResponseEntity.notFound().build();
	}

	@PostMapping("/savetransaction")
	public ResponseEntity<String> create(@Valid @RequestBody Transaction t) {
		service.save(t);
		return ResponseEntity.ok("Transaction successfully created");
	}

	@PutMapping("/updatetransaction/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody Transaction t) {
		t.setId(id);
		service.save(t);
		return ResponseEntity.ok("Transaction successfully updated");
	}

	@DeleteMapping("/deletetransaction/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok("Transaction successfully deleted");
	}
}
