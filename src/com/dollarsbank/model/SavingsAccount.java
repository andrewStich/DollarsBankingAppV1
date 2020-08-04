package com.dollarsbank.model;

import java.util.ArrayList;
import java.util.List;

public class SavingsAccount extends Account {

	private float balance;
	private ArrayList<String> transactions;

	public SavingsAccount(String password) {
		super(password);
	}

	public SavingsAccount(String password, float balance) {
		super(password);
		this.balance = balance;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public List<String> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<String> transactions) {
		this.transactions = transactions;
	}

	public void deposit(float amount) {
		this.balance += amount;
	}

	public void withdraw(float amount) {
		this.balance -= amount;
	}

	public void addTransaction(String transaction) {
		this.transactions.add(transaction);
	}

	public List<String> getFiveRecentTransactions() {
		List<String> toReturn = new ArrayList<String>();
		if (this.transactions.size() < 5) {
			for (int i = transactions.size(); i > 0; i--) {
				toReturn.add(this.transactions.get(i));
			}
		} else {
			for (int i = transactions.size(); i > transactions.size() - 5; i--) {
				toReturn.add(this.transactions.get(i));
			}
		}

		return toReturn;
	}

	@Override
	public String toString() {
		return "SavingsAccount [balance=" + balance + ", transactions=" + transactions + "]";
	}

}
