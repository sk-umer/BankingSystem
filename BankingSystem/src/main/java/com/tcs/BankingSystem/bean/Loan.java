package com.tcs.BankingSystem.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="loan")
public class Loan {
    @Id @GeneratedValue
    private Long id;

    @Column
    @Min(value =0)
    private Double amount;
    
    @Column
    private String type; // HOME, CAR, PERSONAL
    
    @Column
    private Integer durationMonths;
    
    @Column
    private String status = "PENDING"; // PENDING, APPROVED, REJECTED
    
    @Column
    private String remarks;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Employee employee; // approver/rejector
}
