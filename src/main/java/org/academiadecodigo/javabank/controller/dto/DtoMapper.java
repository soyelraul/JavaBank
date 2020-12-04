package org.academiadecodigo.javabank.controller.dto;

import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.persistence.model.account.*;

import java.util.List;
import java.util.stream.Collectors;

public class DtoMapper {

    public static CustomerDto convertToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();

        customerDto.setId(customer.getId());
        customerDto.setProfilePicUrl(customer.getProfilePicUrl());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhoneNumber(customer.getPhoneNumber());

        return customerDto;
    }

    public static Customer convertFromDto(CustomerDto customerDto) {
        Customer customer = new Customer();

        customer.setProfilePicUrl(customerDto.getProfilePicUrl());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhoneNumber(customerDto.getPhoneNumber());

        return customer;
    }

    public static AccountDto convertToDto(Account account) {
        AccountDto accountDto = new AccountDto();

        accountDto.setId(accountDto.getId());
        accountDto.setBalance(account.getBalance());
        accountDto.setCustomer(account.getCustomer());

        return accountDto;
    }

    public static AbstractAccount convertFromDto(AccountDto accountDto) {
        return accountDto.getAccountType() == AccountType.CHECKING ? new CheckingAccount(accountDto.getId(), accountDto.getBalance(), accountDto.getCustomer()) : new SavingsAccount(accountDto.getId(), accountDto.getBalance(), accountDto.getCustomer());
    }

    public static List<CustomerDto> convertCustomerListToDto(List<Customer> customerList) {
        return customerList.stream().map(e -> new CustomerDto(e.getId(), e.getProfilePicUrl(), e.getFirstName(), e.getLastName(), e.getEmail(), e.getPhoneNumber(), e.getAccounts())).collect(Collectors.toList());
    }

    public static List<Customer> convertFromCustomerDtoList(List<CustomerDto> customerDtoList) {
        return customerDtoList.stream().map(e -> new Customer(e.getId(), e.getProfilePicUrl(), e.getFirstName(), e.getLastName(), e.getEmail(), e.getPhoneNumber(), e.getAccounts())).collect(Collectors.toList());
    }

    public static List<AccountDto> convertAccountListToDto(List<AbstractAccount> accountList) {
        return accountList.stream().map(e -> new AccountDto(e.getId(), e.getBalance(), e.getCustomer(), e.getAccountType())).collect(Collectors.toList());
    }

    public static List<AbstractAccount> convertFromAccountDtoList(List<AccountDto> accountDtoList) {
        return accountDtoList.stream().map(e -> e.getAccountType() == AccountType.CHECKING ? new CheckingAccount(e.getId(), e.getBalance(), e.getCustomer()) : new SavingsAccount(e.getId(), e.getBalance(), e.getCustomer())).collect(Collectors.toList());
    }
}
