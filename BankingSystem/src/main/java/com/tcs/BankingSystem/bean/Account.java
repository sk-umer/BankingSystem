package com.tcs.BankingSystem.bean;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.transaction.Transaction;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="account")
public class Account {
    @Id @GeneratedValue
    private Long id;

    @Column
    @NotEmpty
    private String accountNumber;

    @Column
    private String type; // SAVINGS, CURRENT
    
    @Column
    private Double balance;

    @ManyToOne
    private Customer owner;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;
}
