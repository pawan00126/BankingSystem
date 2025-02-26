package org.example;

public class BankAccount {
    private final int accountId;
    private final String name;
    private double balance;

    public BankAccount(int accountId, String name, double balance) {
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
    }

    public int getAccountId() { return accountId; }
    public String getName() { return name; }
    public double getBalance() { return balance; }

    public void setBalance(double balance) { this.balance = balance; }

    @Override
    public String toString() {
        return "Account ID: " + accountId + ", Name: " + name + ", Balance: $" + balance;
    }
}

