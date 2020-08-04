package com.dollarsbank.controller;

import java.util.Scanner;

import com.dollarsbank.model.SavingsAccount;
import com.dollarsbank.model.User;
import com.dollarsbank.utility.ConsolePrintUtility;
import com.dollarsbank.utility.DataGeneratorStubUtil;

public class DollarsBankController {
	
	static final Scanner SCAN = new Scanner(System.in);

	public static void createAccount() {
		ConsolePrintUtility.printCreateAccountHeader();
		
		// Customer Name
		ConsolePrintUtility.printInputOption(0);
		String name = ConsolePrintUtility.getUserInput(SCAN);
		
		// Address
		ConsolePrintUtility.printInputOption(1);
		String address = ConsolePrintUtility.getUserInput(SCAN);
		
		//Contact Number
		ConsolePrintUtility.printInputOption(2);
		int contactNumber = Integer.parseInt(ConsolePrintUtility.getUserInput(SCAN));
		
		// Password
		ConsolePrintUtility.printInputOption(3);
		String password = ConsolePrintUtility.getUserInput(SCAN);
		
		// Initial Deposit
		ConsolePrintUtility.printInputOption(4);
		float initDeposit = Float.parseFloat(ConsolePrintUtility.getUserInput(SCAN));
		
		if(!checkPassword(password)) {
			// Bad password
			ConsolePrintUtility.printInputErrorMessage(2);
		} else {
			SavingsAccount newAcct = new SavingsAccount(password, initDeposit);
			String transaction = ConsolePrintUtility.printAccountCreation(String.valueOf(newAcct.getAcctId())) + "\n"
					+ ConsolePrintUtility.printCurrentBalanceAndTime(newAcct);
			pushTransaction(newAcct, transaction);
			DataGeneratorStubUtil.createAccount(name, address, contactNumber, newAcct);
		}
	}
	
	public static SavingsAccount login() {
		ConsolePrintUtility.printLogInHeader();
		
		// Account Id
		ConsolePrintUtility.printInputOption(12);
		int acctId = Integer.parseInt(ConsolePrintUtility.getUserInput(SCAN));
		
		// password
		ConsolePrintUtility.printInputOption(5);
		String password = ConsolePrintUtility.getUserInput(SCAN);
		
		if(validLogin(acctId, password)) {
			return retrieveAccountFromUser(acctId);
		} else {
			// bad login
			ConsolePrintUtility.printInputErrorMessage(0);
		}
		
		return null;
	}
	
	public static void exit() {
		ConsolePrintUtility.printExitHeader();
		SCAN.close();
		System.exit(0);
	}
	
	public static SavingsAccount deposit(SavingsAccount acct) {
		ConsolePrintUtility.printDepositHeader();
		
		// deposit amount
		ConsolePrintUtility.printInputOption(6);
		float deposit = Float.parseFloat(SCAN.nextLine());
		
		depositAmount(acct, deposit);
		String transaction = ConsolePrintUtility.printDepositTransaction(deposit) + "\n" 
				+ ConsolePrintUtility.printCurrentBalanceAndTime(acct);
		pushTransaction(acct, transaction);
		
		return acct;
	}
	
	public static SavingsAccount withdraw(SavingsAccount acct) {
		ConsolePrintUtility.printWithdrawHeader();
		
		// withdraw ammount
		ConsolePrintUtility.printInputOption(7);
		float withdraw = Float.parseFloat(SCAN.nextLine());
		
		if(validWithdraw(acct, withdraw)) {
			withdrawAmount(acct, withdraw);
			String transaction = ConsolePrintUtility.printDepositTransaction(withdraw) + "\n" 
					+ ConsolePrintUtility.printCurrentBalanceAndTime(acct);
			pushTransaction(acct, transaction);
		} else {
			// bad withdrawl
			ConsolePrintUtility.printInputErrorMessage(5);
		}
		
		return acct;
	}
	
	public static SavingsAccount transfer(SavingsAccount acct) {
		ConsolePrintUtility.printFundTransferHeader();
		
		// Destination Acct ID
		ConsolePrintUtility.printInputOption(8);
		int destAcctId = Integer.parseInt(SCAN.nextLine());
		
		// Transfer Amount
		ConsolePrintUtility.printInputOption(9);
		float amount = Float.parseFloat(SCAN.nextLine());
		
		if(userExists(destAcctId)) {
			if(validWithdraw(acct, amount)) {
				SavingsAccount destAcct = retrieveAccountFromUser(destAcctId);
				
				transferFunds(acct, destAcct, amount);
				String transaction = ConsolePrintUtility.printGiveTransferTransaction(amount, acct.getAcctId(), destAcct.getAcctId()) + "\n" 
						+ ConsolePrintUtility.printCurrentBalanceAndTime(acct);
				pushTransaction(acct, transaction);
				
				transaction = ConsolePrintUtility.printReceiveTransferTransaction(amount, destAcct.getAcctId(), acct.getAcctId())  + "\n" 
						+ ConsolePrintUtility.printCurrentBalanceAndTime(destAcct);
				pushTransaction(destAcct, transaction);
			} else {
				// bad transfer
				ConsolePrintUtility.printInputErrorMessage(5);
			}
		} else {
			// bad destination user
			ConsolePrintUtility.printInputErrorMessage(6);
		}
		
		return acct;
	}
	
	public static void printRecentTransactions(SavingsAccount acct) {
		ConsolePrintUtility.printRecentTransactionHeader();
		ConsolePrintUtility.printRecentTransactions(acct);
	}
	
	public static void printUser(SavingsAccount acct) {
		ConsolePrintUtility.printCustomerInfoHeader();
		ConsolePrintUtility.printCustomerInformation(retriveUserFromAccount(acct));
	}
	
	private static User retriveUserFromAccount(SavingsAccount acct) {
		User user = new User();
		for(User u: DataGeneratorStubUtil.userList) {
			if(u.getAcct() == acct) {
				user = u;
				return user;
			}
		}
		return null;
	}

	private static void transferFunds(SavingsAccount acct, SavingsAccount destAcct, float amount) {
		acct.withdraw(amount);
		destAcct.deposit(amount);
	}

	public static void depositAmount(SavingsAccount acct, float amount) {
		acct.deposit(amount);
	}
	
	public static void withdrawAmount(SavingsAccount acct, float amount) {
		acct.withdraw(amount);
	}
	
	public static boolean validWithdraw(SavingsAccount acct, float amount) {
		if(amount <= acct.getBalance()) {
			return true;
		}
		
		return false;
	}
	
	public static void pushTransaction(SavingsAccount acct, String transaction) {
		acct.addTransaction(transaction);
	}
	
	public static boolean checkPassword(String password) {
		if (password.length() != 8 
				|| password.equals(password.toLowerCase()) 
				|| password.equals(password.toUpperCase()) 
				|| password.matches("[A-Za-z0-9 ]*")) {
					return false;
				}
		return true;
	}
	
	public static boolean validLogin(int acctId, String password) {
		for (User u: DataGeneratorStubUtil.userList) {
			if (acctId == (u.getAcct().getAcctId()) && password.equals(u.getAcct().getPassword())) {
				System.out.println("Valid login");
				return true;
			}
		}
		return false;
	}
	
	public static boolean userExists(int acctId) {
		if(retrieveAccountFromUser(acctId) == null) {
			return false;
		}
		return true;
	}
	
	public static SavingsAccount retrieveAccountFromUser(int acctId) {
		SavingsAccount acct = null;
		for(User u: DataGeneratorStubUtil.userList) {
			if(acctId == u.getAcct().getAcctId()) {
				acct = (SavingsAccount) u.getAcct();
			}
		}
		
		return acct;
	}
	
}
