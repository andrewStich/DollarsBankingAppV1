package com.dollarsbank.model;

import com.dollarsbank.utility.ColorUtility;

public class Account {
	
	private int acctId;
	private String password;

	public Account(String password) {
		super();
		this.acctId = (int) (Math.random() * (999999999 - 100000000) + 100000000);
		this.password = password;
		
		ColorUtility.printYellow("Your account ID is: " + acctId + ". Keep it secret, keep it safe.");
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public int getAcctId() {
		return acctId;
	}

	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [acctId=" + acctId + ", password=" + password + "]";
	}

}
