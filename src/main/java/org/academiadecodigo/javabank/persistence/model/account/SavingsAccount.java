package org.academiadecodigo.javabank.persistence.model.account;

import org.academiadecodigo.javabank.persistence.model.Customer;

import javax.persistence.Entity;

/**
 * A savings account domain entity which requires a minimum balance
 * and can only be used for transferring money, not for debiting
 *
 * @see Account
 * @see AccountType#SAVINGS
 */
@Entity
public class SavingsAccount extends AbstractAccount {

    /**
     * The minimum balance to maintain on the account
     */
    private static final double MIN_BALANCE = 100;

    /**
     * Creates a new {@code SavingsAccount} instance
     *
     * @see Account#Account(int)
     */
    public SavingsAccount() {
    }

    public SavingsAccount(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    /**
     * @see Account#getAccountType()
     */
    @Override
    public AccountType getAccountType() {
        return AccountType.SAVINGS;
    }

    /**
     * Checks if the account can be debited without going below the minimum balance
     *
     * @see SavingsAccount#MIN_BALANCE
     * @see Account#canDebit(double)
     */
    @Override
    public boolean canDebit(double amount) {
        return super.canDebit(amount) && (getBalance() - amount) >= MIN_BALANCE;
    }

    /**
     * @see Account#canWithdraw()
     */
    @Override
    public boolean canWithdraw() {
        return false;
    }
}
