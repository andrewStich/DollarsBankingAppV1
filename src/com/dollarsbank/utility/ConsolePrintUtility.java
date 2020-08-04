package com.dollarsbank.utility;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.dollarsbank.model.SavingsAccount;
import com.dollarsbank.model.User;

public class ConsolePrintUtility {

	public static void printWelcomeHeader() {
		ColorUtility.printBlue("+---------------------------+");
		ColorUtility.printBlue("| DOLLARSBANK Welcomes You! |");
		ColorUtility.printBlue("+---------------------------+");
	}
	
	// Print the header for the signed in menu
	public static void printSignedInHeader() {
		ColorUtility.printBlue("+---------------------+");
		ColorUtility.printBlue("| WELCOME Customer!!! |");
		ColorUtility.printBlue("+---------------------+");
	}
	
	// Print the header for creating an account
	public static void printCreateAccountHeader() {
		ColorUtility.printBlue("+-------------------------------+");
		ColorUtility.printBlue("| Enter Details For New Account |");
		ColorUtility.printBlue("+-------------------------------+");
	}
	
	// Print the header for customer log in
	public static void printLogInHeader() {
		ColorUtility.printBlue("+---------------------+");
		ColorUtility.printBlue("| Enter Login Details |");
		ColorUtility.printBlue("+---------------------+");
	}
	
	// Print the header for the deposit transaction
	public static void printDepositHeader() {
		ColorUtility.printBlue("+--------------------+");
		ColorUtility.printBlue("| Deposit To Account |");
		ColorUtility.printBlue("+--------------------+");
	}
	
	// Print the header for the withdraw transaction
	public static void printWithdrawHeader() {
		ColorUtility.printBlue("+-----------------------+");
		ColorUtility.printBlue("| Withdraw From Account |");
		ColorUtility.printBlue("+-----------------------+");
	}
	
	// Print the header for the funds transfer transaction
	public static void printFundTransferHeader() {
		ColorUtility.printBlue("+----------------+");
		ColorUtility.printBlue("| Transfer Funds |");
		ColorUtility.printBlue("+----------------+");
	}

	// Print the header for the 5 recent transaction
	public static void printRecentTransactionHeader() {
		ColorUtility.printBlue("+------------------------+");
		ColorUtility.printBlue("| 5 Recent Transactions: |");
		ColorUtility.printBlue("+------------------------+");
	}
	
	// Print the header for displaying customer information
	public static void printCustomerInfoHeader() {
		ColorUtility.printBlue("+-----------------------+");
		ColorUtility.printBlue("| Customer Information: |");
		ColorUtility.printBlue("+-----------------------+");
	}
	
	// Print the header for exiting the program
	public static void printExitHeader() {
		ColorUtility.printBlue("+----------------------------------+");
		ColorUtility.printBlue("| Thank You For Using DOLLARSBANK! |");
		ColorUtility.printBlue("+----------------------------------+");
	}
	
	// Print the menu options for the initial menu
	public static void printWelcomeMenu() {
		System.out.println("1. Create New Account");
		System.out.println("2. Login");
		System.out.println("3. Exit");
	}
	
	// Print the menu options for the signed in menu
	public static void printSignedInMenu() {
		System.out.println("1. Deposit Amount");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Funds Transfer");
		System.out.println("4. View 5 Recent Transactions");
		System.out.println("5. Display Customer Information");
		System.out.println("6. Sign Out");
	}
	
	// Display an input message
		public static void printInputOption(int option) {
			switch(option) {
			case 0:
				System.out.println("Customer Name:");
				break;
			case 1:
				System.out.println("Customer Address:");
				break;
			case 2:
				System.out.println("Customer Contact Number:");
				break;
			case 3:
				System.out.println("Password: 8 Characters with Lower, Upper, and Special");
				break;
			case 4:
				System.out.println("Initial Deposit:");
				break;
			case 5:
				System.out.println("Password:");
				break;
			case 6:
				System.out.println("Enter Deposit Amount:");
				break;
			case 7:
				System.out.println("Enter Withdraw Amount:");
				break;
			case 8:
				System.out.println("Enter User ID of Account to Transfer to:");
				break;
			case 9:
				System.out.println("Enter Transfer Amount:");
				break;
			case 10:
				System.out.println();
				ColorUtility.printGreen("Enter Choice (1, 2, 3) :");
				break;
			case 11:
				System.out.println();
				ColorUtility.printGreen("Enter Choice (1, 2, 3, 4, 5, 6) :");
				break;
			case 12:
				System.out.println("Enter Account Number: ");
				break;
			}
			
		}
		
		// Display an error message when the customer has given some incorrect input
		public static void printInputErrorMessage(int option) {
			switch(option) {
			case 0:
				// When user is logging in and the user ID and password don't match existing ones
				ColorUtility.printRed("Invalid Credentials. Please Try Again!");
				break;
			case 1:
				// When user is creating account and tries to give user ID that exists
				ColorUtility.printRed("That User ID already exists. Please enter a unique ID!");
				break;
			case 2:
				// When user is creating account and does not make a password that follows the given criteria(8 chars, Lower, Upper, Special)
				ColorUtility.printRed("That Password does not fit the criteria. Please ensure the criteria are met!");
				break;
			case 3:
				// When user is creating account and tries to enter a negative value for the initial deposit
				ColorUtility.printRed("You cannot create an account with a negative balance. Please enter a positive number!");
				break;
			case 4:
				// When user attempts to enter non-numbers into number only inputs, such as Deposit or Withdraw, or enters a negative number value
				ColorUtility.printRed("Invalid input. Please enter postive number values only!");
				break;
			case 5:
				// When user attempts to withdraw/transfer more money than they have
				ColorUtility.printRed("You do not have enough in your balance to perform this transaction");
				break;
			case 6:
				// When user attempts to transfer to account that doesn't exist
				ColorUtility.printRed("User not found. Please ensure the user is correct!");
				break;
			}
		}
		
		public static String printCurrentBalanceAndTime(SavingsAccount savings) {
			return "Balance - " + savings.getBalance() + " as of " + LocalDateTime.now();
		}
		
		public static String printDepositTransaction(float deposit) {
			return "Deposited " + deposit;
		}
		
		public static String printWithdrawTransaction(float withdraw) {
			return "Withdrew " + withdraw;
		}
		
		public static String printAccountCreation(String userId) {
			return "Account creation for account [" + userId + "]";
		}
		
		public static String printGiveTransferTransaction(float transfer, int user1, int user2) {
			return "User [" + user1 + "] transfered " + transfer + " to User [" + user2 + "]";
		}
		
		public static String printReceiveTransferTransaction(float transfer, int user1, int user2) {
			return "User [" + user1 + "] receieved " + transfer + " from User [" + user2 + "]";
		}
		
		// Print customer information(not password of course)
		public static void printCustomerInformation(User user) {
			SavingsAccount savingsAcc = (SavingsAccount) user.getAcct();
			System.out.println("Name: " + user.getName());
			System.out.println("Address: " + user.getAddress());
			System.out.println("Contact Number: " + user.getContactNum());
			System.out.println("User ID: " + savingsAcc.getAcctId());
			System.out.println("Balance: " + savingsAcc.getBalance());
		}
		
		// Print an Account's recent transactions
		public static void printRecentTransactions(SavingsAccount savings) {
			for(String transaction: savings.getFiveRecentTransactions()) {
				System.out.println(transaction);
			}
		}
		
		public static String getUserInput(Scanner scan) {
			ColorUtility.startColorText(32);
			String toReturn = scan.nextLine();
			ColorUtility.endColorText();
			return toReturn;
		}
}
