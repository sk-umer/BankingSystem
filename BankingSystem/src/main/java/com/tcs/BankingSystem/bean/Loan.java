package com.tcs.BankingSystem.bean;

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
@Table(name = "loan")
public class Loan {
	@Id
	@GeneratedValue
	private Long id;

	@NotNull(message = "Loan amount cannot be null")
	@Min(value = 1, message = "Loan amount must be greater than 0")
	private Double amount;

	@NotEmpty(message = "Loan type cannot be empty")
	private String type; // HOME, CAR, PERSONAL

	@NotNull(message = "Duration cannot be null")
	@Min(value = 1, message = "Duration must be at least 1 month")
	private Integer durationMonths;

	@NotEmpty(message = "Status cannot be empty")
	private String status = "PENDING"; // PENDING, APPROVED, REJECTED

	private String remarks;

	@ManyToOne
	@JsonManagedReference
	private Customer customer;

	@ManyToOne
	@JsonManagedReference
	private Employee employee; // approver/rejector
}
