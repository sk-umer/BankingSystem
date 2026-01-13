package com.tcs.BankingSystem.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.tcs.BankingSystem.service.CustomerService;
import com.tcs.BankingSystem.bean.Customer;
import java.util.List;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping("/getallcustomers")
	public ResponseEntity<List<Customer>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/getcustomer/{id}")
	public ResponseEntity<Customer> getById(@PathVariable Long id) {
		Customer c = service.getById(id);
		return c != null ? ResponseEntity.ok(c) : ResponseEntity.notFound().build();
	}

	@PostMapping("/savecustomer")
	public ResponseEntity<String> create(@Valid @RequestBody Customer c) {
		service.save(c);
		return ResponseEntity.ok("Customer successfully created");
	}

	@PutMapping("/updatecustomer/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody Customer c) {
		c.setId(id);
		service.save(c);
		return ResponseEntity.ok("Customer successfully updated");
	}

	@DeleteMapping("/deletecustomer/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok("Customer successfully deleted");
	}
}
