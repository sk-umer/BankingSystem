package com.tcs.BankingSystem.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.tcs.BankingSystem.service.EmployeeService;
import com.tcs.BankingSystem.bean.Employee;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/getallemployees")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/getemployee/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        Employee e = service.getById(id);
        return e != null ? ResponseEntity.ok(e) : ResponseEntity.notFound().build();
    }

    @PostMapping("/saveemployee")
    public ResponseEntity<String> create(@Valid @RequestBody Employee e) {
        service.save(e);
        return ResponseEntity.ok("Employee successfully created");
    }

    @PutMapping("/updateemployee/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody Employee e) {
        e.setId(id);
        service.save(e);
        return ResponseEntity.ok("Employee successfully updated");
    }

    @DeleteMapping("/deleteemployee/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Employee successfully deleted");
    }
}
