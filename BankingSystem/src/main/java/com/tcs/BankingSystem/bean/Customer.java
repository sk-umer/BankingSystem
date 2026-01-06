package com.tcs.BankingSystem.bean;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customer")
public class Customer {
    @Id @GeneratedValue
    private Long id;

    @Column
    private String username;

    @Column
    private String password;
    
    @Column
    private String email;
    
    @Column
    private String fullName;
    
    @Column
    private String address;
    
    @Column
    private String phone;

    @Column
    private String role = "CUSTOMER";

    @OneToMany(mappedBy = "owner")
    private List<Account> accounts;

    @OneToMany(mappedBy = "customer")
    private List<Loan> loans;
}
