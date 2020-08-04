package com.dollarsbank.application;

import java.util.Scanner;

import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.model.SavingsAccount;
import com.dollarsbank.model.User;
import com.dollarsbank.utility.ConsolePrintUtility;
import com.dollarsbank.utility.DataGeneratorStubUtil;

public class DollarsBankApplication {
	
	static final Scanner SCAN = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean loggedIn = false;
		SavingsAccount currentAccount = null;
		
		User testUser = new User("Andrew", "home", 1234567890, new SavingsAccount("Pass", 1500));
		DataGeneratorStubUtil.createAccount(testUser);
		
		User testUser1 = new User("John", "Seattle, WA", 8675309, new SavingsAccount("Doggie", 750));
		DataGeneratorStubUtil.createAccount(testUser1);
		
		while(true) {
			if(!loggedIn) {
				ConsolePrintUtility.printWelcomeHeader();
				ConsolePrintUtility.printWelcomeMenu();
				
				// menu select
				ConsolePrintUtility.printInputOption(10);
				String menuInput = SCAN.nextLine();
				switch(menuInput) {
				case "1":
					DollarsBankController.createAccount();
					break;
				case "2":
					currentAccount = DollarsBankController.login();
					break;
				case "3":
					DollarsBankController.exit();
					break;
				default:
					System.out.println("Invalid Input");
					break;
				}
			} else {
				ConsolePrintUtility.printSignedInHeader();
				ConsolePrintUtility.printSignedInMenu();
				
				// sign in menu select
				ConsolePrintUtility.printInputOption(11);
				String menuInput = SCAN.nextLine();
				switch(menuInput) {
				case "1":
					currentAccount = DollarsBankController.deposit(currentAccount);
					break;
				case "2":
					currentAccount = DollarsBankController.withdraw(currentAccount);
					break;
				case "3":
					currentAccount = DollarsBankController.transfer(currentAccount);
					break;
				case "4":
					DollarsBankController.printRecentTransactions(currentAccount);
					break;
				case "5":
					DollarsBankController.printUser(currentAccount);
					break;
				case "6":
					loggedIn = false;
					break;
				case "7":
					System.out.println(currentAccount);
					break;
				default:
					System.out.println("Invalid Input");
				}
			}
		}
	}
}
