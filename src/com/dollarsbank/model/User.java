package com.dollarsbank.model;

public class User {

	private String name;
	private String address;
	private int contactNum;
	private Account acct;

	public User(String name, String address, int contactNum, Account acct) {
		super();
		this.name = name;
		this.address = address;
		this.contactNum = contactNum;
		this.acct = acct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContactNum() {
		return contactNum;
	}

	public void setContactNum(int contactNum) {
		this.contactNum = contactNum;
	}

	public Account getAcct() {
		return acct;
	}

	public void setAcct(Account acct) {
		this.acct = acct;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", address=" + address + ", contactNum=" + contactNum + ", acct=" + acct + "]";
	}

}
