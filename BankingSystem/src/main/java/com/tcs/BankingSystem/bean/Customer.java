package com.tcs.BankingSystem.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, unique = true)
	@NotEmpty(message = "Username cannot be empty")
	private String username;

	@Column(nullable = false)
	@NotEmpty(message = "Password cannot be empty")
	private String password;

	@Column(nullable = false, unique = true)
	@Email(message = "Email should be valid")
	@NotEmpty(message = "Email cannot be empty")
	private String email;

	@NotEmpty(message = "Full name cannot be empty")
	private String fullName;

	@NotEmpty(message = "Address cannot be empty")
	private String address;

	@NotEmpty(message = "Phone cannot be empty")
	private String phone;

	private String role = "CUSTOMER";

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Account> accounts;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Loan> loans;
}
