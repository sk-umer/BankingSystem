package com.tcs.BankingSystem.bean;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "transaction_db")
public class Transaction {
	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty(message = "Transaction type cannot be empty")
	private String type; // DEPOSIT, WITHDRAW, TRANSFER

	@NotNull(message = "Amount cannot be null")
	@Min(value = 1, message = "Amount must be greater than 0")
	private Double amount;

	private LocalDateTime timestamp = LocalDateTime.now();

	@ManyToOne
	@JsonManagedReference
	private Account account;

	@ManyToOne
	@JsonManagedReference
	private Account sourceAccount;

	@ManyToOne
	@JsonManagedReference
	private Account destinationAccount;
}
