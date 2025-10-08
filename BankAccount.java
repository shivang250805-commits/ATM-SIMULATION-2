package model;

import java.util.ArrayList;
import java.util.List;

import util.Transaction;

public class BankAccount {
    private String userName;
    private String pin;
    private double balance;
    private List<Transaction> transactions;

    public BankAccount(String userName, String pin, double balance) {
        this.userName = userName;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public boolean validatePin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount));
            return true;
        }
        return false;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getUserName() {
        return userName;
    }
}
