package com.tcs.BankingSystem.bean;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee")
public class Employee {
    @Id @GeneratedValue
    private Long id;

    @Column
    @NotEmpty
    private String username;

    @Column
    private String password;
    
    @Column
    private String email;
    
    @Column
    private String fullName;
    
    @Column
    private String department;

    @Column
    private String role; // "ADMIN" or "EMPLOYEE"

    @OneToMany(mappedBy = "employee")
    private List<Loan> processedLoans;
}
