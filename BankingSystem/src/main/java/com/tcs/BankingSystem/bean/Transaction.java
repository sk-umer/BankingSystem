package com.tcs.BankingSystem.bean;

import java.time.LocalDateTime;

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
@Table(name="transaction")
public class Transaction {
    @Id @GeneratedValue
    private Long id;

    @Column
    private String type; // DEPOSIT, WITHDRAW, TRANSFER
    
    @Column
    @Min(value = 0)
    private Double amount;
    
    @Column
    private LocalDateTime timestamp = LocalDateTime.now();

    @ManyToOne
    private Account account;
}
