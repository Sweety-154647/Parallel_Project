package com.cg.pra.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.cg.pra.appException.AppException;
import com.cg.pra.beans.Account;

//this interface is used to enhance abstraction of AccountDao layer
public interface AccountDao {

	// method declarations of AccountDao layer
	boolean createAccount(Account a);

	double getBalance(Account a);

	double deposit(Account a, double rechargeAmount);

	double withdraw(Account a, double withdrawAmount);

	double fundTransfer(Account a, double amount, String phn);

	ArrayList<String> printTransaction(Account a);

	HashMap<String, Account> getHash();

}
