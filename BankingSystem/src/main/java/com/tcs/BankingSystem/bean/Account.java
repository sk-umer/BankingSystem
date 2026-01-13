package com.tcs.BankingSystem.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @Column(nullable=false, unique=true)
    @NotEmpty(message = "Account number cannot be empty")
    private String accountNumber;

    @NotEmpty(message = "Account type cannot be empty")
    private String type; // SAVINGS, CURRENT

    @NotNull(message = "Balance cannot be null")
    @Min(value = 0, message = "Balance must be non-negative")
    private Double balance;

    @ManyToOne
	@JsonBackReference
    private Customer owner;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Transaction> transactions;
}
