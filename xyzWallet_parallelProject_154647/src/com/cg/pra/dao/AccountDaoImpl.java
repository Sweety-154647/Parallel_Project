package com.cg.pra.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cg.pra.appException.AppException;
import com.cg.pra.beans.Account;

//this class is is used to interact between Account class and Service layer
public class AccountDaoImpl implements AccountDao {

	HashMap<String, Account> accountEntry;

	public AccountDaoImpl() {
		accountEntry = new HashMap<>();
		accountEntry.put("9010210131", new Account("Vaishali", 200, "vaishali@gmail.com", "9010210131", "vaish@1"));
		accountEntry.put("9823920123", new Account("Megha", 453, "megha@gmail.com", "9823920123", "megh@1"));
		accountEntry.put("9932012345", new Account("Vikas", 631, "vikas@gmail.com", "9932012345", "vikas@1"));
		accountEntry.put("9896104567", new Account("Anju", 521, "anju@gmail.com", "9896104567", "anju@1"));
		accountEntry.put("8685086613", new Account("Tushar", 632, "tushar@gmail.com", "8685086613", "tush@1"));
	}

	// this method is used to create account of particular user
	@Override
	public boolean createAccount(Account a) {
		accountEntry.put(a.getPhnNo(), a);
		return true;
	}

	@Override
	// this is method to get Account balance of particular user of having
	// particular mobile number
	public double getBalance(Account a) {
		Double b = a.getAccountBalance();
		return b;
	}

	@Override
	// this method is used to get balance details after user deposit some amount
	public double deposit(Account a, double rechargeAmount) {
		double bal = a.getAccountBalance() + rechargeAmount;
		a.setAccountBalance(bal);
		a.getArrayList().add("\nDeposited  " + rechargeAmount + " Final Balance " + a.getAccountBalance());
		return bal;
	}

	@Override
	// this method is used to get balance details after user withdraw some amount
	public double withdraw(Account a, double withdrawAmount) {
		double bal = a.getAccountBalance() - withdrawAmount;
		a.setAccountBalance(bal);
		a.getArrayList().add("\nWithdrawn: " + withdrawAmount + " Final Balance " + a.getAccountBalance());
		return bal;
	}

	@Override
	// this method is used to get balance details after fundtransfer takes place
	// from one account to some other account
	public double fundTransfer(Account a, double amount, String phn) {
		double nb = 0;
		double yb = 0;
		for (Map.Entry<String, Account> m : accountEntry.entrySet()) {
			if (phn.equals(m.getValue().getPhnNo())) {
				nb = m.getValue().getAccountBalance() + amount;
				m.getValue().setAccountBalance(nb);
				yb = a.getAccountBalance() - amount;
				a.setAccountBalance(yb);
				a.getArrayList()
						.add("\nTransfered Amount: " + amount + " Your Final Balance is: " + a.getAccountBalance());
			}
		}
		return yb;
	}

	@Override
	// this method is used to get arraylist which contain list of last transactions.
	public ArrayList<String> printTransaction(Account a) {

		return a.getArrayList();

	}

	@Override
	// this method is used to get hashmap which contain account details of various
	// user
	public HashMap<String, Account> getHash() {
		return accountEntry;
	}

}
