package com.cg.pra.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cg.pra.appException.AppException;
import com.cg.pra.beans.Account;
import com.cg.pra.dao.AccountDao;
import com.cg.pra.dao.AccountDaoImpl;

//this layer is used to interact between user and AccountDao layer to enhance abstraction
public class ServiceImpl implements Service {
	public AccountDaoImpl acc = new AccountDaoImpl();

	@Override
	// method used to get balance of particular user
	public double getBalance(Account a) throws AppException {
		double l = acc.getBalance(a);
		return l;

	}

	@Override
	// method to create account using create method of AccountDao layer
	public boolean create(Account a) {
		return acc.createAccount(a);

	}

	@Override
	// method to validate user phone number and password
	public Account valUserPass(String phnNo, String pass) throws AppException {
		Account ac = new Account();

		int i = 0;

		for (Map.Entry<String, Account> h : acc.getHash().entrySet()) {
			if (phnNo.equals(h.getKey()) && pass.equals(h.getValue().getPass())) {
				i = 1;
				ac = h.getValue();
				break;
			}

		}
		if (i == 0)
			throw new AppException("Enter valid user phn Number and password");

		return ac;
	}

	@Override
	// method to validate fields and then to get balance using Accountdao layer
	// method after depositing some amount
	public double deposit(Account a, double rechargeAmount) throws AppException {
		if (rechargeAmount <= 0)
			throw new AppException("Enter recharge amount greater than 0");

		double b = acc.deposit(a, rechargeAmount);
		return b;
	}

	@Override
	// method to validate fields and then to get balance using Accountdao layer
	// method after withdrawing some amount
	public double withdraw(Account a, double withdraw) throws AppException {
		if (withdraw <= 0 || withdraw >= acc.getBalance(a))
			throw new AppException("Enter withdraw Amount greater than 0 and less than Account balance");

		double b = acc.withdraw(a, withdraw);
		return b;
	}

	@Override
	// method to validate fields and then to get balance using Accountdao layer
	// method after tranfering amount from one account to another
	public double fundTransfer(Account a, Double amount, String phnNo) throws AppException {
		if (phnNo.equals(a.getPhnNo()) || !(gethash().containsKey(phnNo))) {
			throw new AppException(
					"This  Phone number must exists in list and also diffrent from number which is tranfering amount\n");
		}
		if (amount <= 0 || amount >= acc.getBalance(a))
			throw new AppException("Enter  Amount greater than  0 and less than account balance");
		double n = acc.fundTransfer(a, amount, phnNo);
		return n;
	}

	@Override
	// method to get arraylist from account dao layer
	public ArrayList<String> printTransaction(Account a) {
		ArrayList<String> ar = acc.printTransaction(a);
		return ar;

	}

	@Override
	// method to get hashmap from Account dao layer method
	public HashMap<String, Account> gethash() {

		return acc.getHash();
	}

	@Override
	// method to validate name of user who is creating new account
	public void validateName(String name) throws AppException {
		if (!(name.matches("[A-Z]{1}[a-z]{3,10}")))
			throw new AppException("First character should be capital. Please enter again\n\n");
	}

	@Override
	// method to validate Phone number of user who is creating new account
	public void validatephn(String phnNo) throws AppException {
		for (Map.Entry<String, Account> m : acc.getHash().entrySet()) {
			if (phnNo.matches(m.getValue().getPhnNo()))
				throw new AppException(
						"User Phone number already exits.Enter valid Phone Number.Please enter again\n\\n");
		}
		if (!phnNo.matches("[0-9]{10}"))
			throw new AppException("MobileNo should be atleast 10 digit.Please enter again\n\n");

	}

	@Override
	// method to validate mailId of user who is creating new account
	public void validatemailId(String mailId) throws AppException {
		if (!mailId.matches("[a-z0-9]{3,10}[@]{1}[a-z]{3,5}[.com]{2,4}"))
			throw new AppException("Enter valid mail id eg-ram@gmail.com.Please enter again\n\n");

	}

	@Override
	// method to check balance>0 of user who is creating new account
	public void validatbalance(double bal) throws AppException {
		if ((bal <= 0))
			throw new AppException("Balance should be greater than zero.Please enter again\n\n");

	}

	@Override
	// method to validate password of user who is creating new account
	public void validatpassword(String pass) throws AppException {
		if (!(pass.matches("[A-z0-9]{3,8}[@]{1}[a-z0-9]{0,8}")))
			throw new AppException(
					"Enter valid password which" + "  have atleast one @ character.Please enter again\n\n");
	}

}
