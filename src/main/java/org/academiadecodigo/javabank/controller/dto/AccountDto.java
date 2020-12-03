package org.academiadecodigo.javabank.controller.dto;

import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.persistence.model.account.AccountType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountDto {

    private int id;

    @NotNull(message = "balance is mandatory")
    @NotBlank(message = "balance is mandatory")
    @Size(min = 1, max = 1000)
    private double balance;

    @NotNull(message = "customer is mandatory")
    @NotBlank(message = "customer is mandatory")
    private Customer customer;

    @NotNull(message = "account type is mandatory")
    @NotBlank(message = "account type is mandatory")
    private AccountType accountType;

    public AccountDto() {
    }

    public AccountDto(int id, double balance, Customer customer, AccountType accountType) {
        this.id = id;
        this.balance = balance;
        this.customer = customer;
        this.accountType = accountType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}