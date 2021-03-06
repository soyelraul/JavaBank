package org.academiadecodigo.javabank.persistence.model.account;

import org.academiadecodigo.javabank.persistence.model.Customer;

public interface Account {
    void addBalance(double amount);

    void removeBalance(double amount);

    void setCustomer(Customer customer);

    Customer getCustomer();

    /**
     * Gets the account id
     *
     * @return the account id
     */
    int getId();

    /**
     * Gets the account balance
     *
     * @return the account balance
     */
    double getBalance();

    /**
     * Checks if a specific amount can be credited on the account
     *
     * @param amount the amount to check
     * @return {@code true} if the account can be credited
     */
    boolean canCredit(double amount);

    /**
     * Checks if a specific amount can be debited from the account
     *
     * @param amount the amount to check
     * @return {@code true} if the account can be debited
     */
    boolean canDebit(double amount);

    /**
     * Checks if the account can be withdrawn
     *
     * @return {@code true} if withdraw can be done
     */
    boolean canWithdraw();

    /**
     * Gets the account type
     *
     * @return the account type
     */
    AccountType getAccountType();
}
