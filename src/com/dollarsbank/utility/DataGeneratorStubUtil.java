package com.dollarsbank.utility;

import java.util.ArrayList;
import java.util.List;

import com.dollarsbank.model.SavingsAccount;
import com.dollarsbank.model.User;

public class DataGeneratorStubUtil {

	public static List<User> userList = new ArrayList<User>();
	
	public static void createAccount(String name, String address, int contactNumber, String password, float initialDeposit) {
		userList.add(new User(name, address, contactNumber, new SavingsAccount(password, initialDeposit)));
	}
	
	
		public static void createAccount(String name, String address, int contactNum, SavingsAccount savings) {
			userList.add(new User(name, address, contactNum, savings));
		}
	
	public static void createAccount(User user) {
		userList.add(user);
	}
	
}
