package com.cg.pra.beans;

import java.util.ArrayList;

//this is account class which contains various fields of account class
public class Account {
	private String accountType;
	private String customerName;
	private String mailId;
	private String phnNo;
	private double accountBalance;
	private String pass;

	public Account() {

	}

	public Account(String customerName, double accountBalance, String mailId, String phnNo, String pass) {
		this.customerName = customerName;
		this.accountBalance = accountBalance;
		this.mailId = mailId;
		this.phnNo = phnNo;
		this.pass = pass;
	}

	private ArrayList<String> arr = new ArrayList<>();

	// getters and setter for various fields of Account class
	public String getAccountType() {
		return accountType;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPhnNo() {
		return phnNo;
	}

	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public ArrayList<String> getArrayList() {
		return arr;
	}

}
