package com.tcs.BankingSystem.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.tcs.BankingSystem.service.LoanService;
import com.tcs.BankingSystem.bean.Loan;
import java.util.List;

@RestController
public class LoanController {

	@Autowired
	private LoanService service;

	@GetMapping("/getallloans")
	public ResponseEntity<List<Loan>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/getloan/{id}")
	public ResponseEntity<Loan> getById(@PathVariable Long id) {
		Loan l = service.getById(id);
		return l != null ? ResponseEntity.ok(l) : ResponseEntity.notFound().build();
	}

	@PostMapping("/saveloan")
	public ResponseEntity<String> create(@Valid @RequestBody Loan l) {
		service.save(l);
		return ResponseEntity.ok("Loan successfully created");
	}

	@PutMapping("/updateloan/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody Loan l) {
		l.setId(id);
		service.save(l);
		return ResponseEntity.ok("Loan successfully updated");
	}

	@DeleteMapping("/deleteloan/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok("Loan successfully deleted");
	}
}
