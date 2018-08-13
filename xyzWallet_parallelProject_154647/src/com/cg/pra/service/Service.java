package com.cg.pra.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.cg.pra.appException.AppException;
import com.cg.pra.beans.Account;

//this interface is used to provide layer to interact with user and to provide abstraction
public interface Service {
	// declaration of various methods used in service layer
	boolean create(Account a);

	double getBalance(Account a) throws AppException;

	double deposit(Account a, double rechargeAmount) throws AppException;

	Account valUserPass(String phnNo, String pass) throws AppException;

	double withdraw(Account a, double withdraw) throws AppException;

	double fundTransfer(Account a, Double amount, String phnNo) throws AppException;

	ArrayList<String> printTransaction(Account a);

	HashMap<String, Account> gethash();

	void validateName(String name) throws AppException;

	void validatephn(String phnNo) throws AppException;

	void validatemailId(String mailId) throws AppException;

	void validatbalance(double bal) throws AppException;

	void validatpassword(String pass) throws AppException;
}
