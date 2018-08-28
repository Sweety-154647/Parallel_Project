package com.cg.pra.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.pra.appException.AppException;
import com.cg.pra.beans.Account;
import com.cg.pra.service.Service;
import com.cg.pra.service.ServiceImpl;

//thsi class is used to intract with user
public class MainUI {
	public static Service ser = new ServiceImpl();

	public static void main(String[] args) {

		int n = 0;
		do {
			System.out.println("\nMenu:   ");
			System.out.println("1.Create Account");
			System.out.println("2.Login Account");
			System.out.println("3.exit");
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			switch (n) {
			case 1: {
				String name;
				String phnNo;
				String mailId;
				double bal;
				String pass;
				while (true) {
					System.out.println("Enter Customer Name:");
					name = sc.next();
					try {
						ser.validateName(name);
						break;
					} catch (AppException e) {
					}
				}
				while (true) {
					System.out.println("Enter MobileNumber:");
					phnNo = sc.next();
					try {
						ser.validatephn(phnNo);
						break;
					} catch (AppException e) {
					}
				}
				while (true) {

					try {
						System.out.println("Enter mailId");
						mailId = sc.next();
						ser.validatemailId(mailId);
						;
						break;
					} catch (AppException e) {
					}
				}
				while (true) {

					try {
						System.out.println("Enter account balance");
						bal = sc.nextDouble();
						ser.validatbalance(bal);
						break;
					} catch (AppException e) {
					}
				}

				while (true) {

					try {
						System.out.println("Enter password");
						pass = sc.next();
						ser.validatpassword(pass);
						break;
					} catch (AppException e) {
					}
				}

				Account a = new Account(name, bal, mailId, phnNo, pass);
				boolean g = ser.create(a);
				if (g == true)
					System.out.println("Congratulations!!Your Account created successfully.");

				break;
			}
			case 2: {
				int n1 = 0;
				String phnNo;
				String pass;
				Account m;
				while (true) {
					System.out.println("Enter mobile number");
					phnNo = sc.next();
					System.out.println("Enter password");
					pass = sc.next();

					try {
						m = ser.valUserPass(phnNo, pass);
						break;
					} catch (AppException e1) {
					}
				}
				System.out.println("You are logged in\n");
				do {

					System.out.println("1.Show Account Balance");
					System.out.println("2.Deposit");
					System.out.println("3.Withdraw Amount ");
					System.out.println("4.Fund Tranfer ");
					System.out.println("5. Print Last Transaction");
					System.out.println("6.Exit ");
					System.out.println("Enter you requirement:");
					n1 = sc.nextInt();
					if (n1 >= 0) {
						switch (n1) {
						case 1: {

							double x;
							while (true) {
								try {
									x = ser.getBalance(m);
									break;
								} catch (AppException e) {

								}
							}
							System.out.println("Your Account Balance is: " + x + "\n\n");
							break;
						}
						case 2: {

							
							double bal;
							while (true) {
								try {
									System.out.println("Enter deposit amount");
									double b = sc.nextDouble();
									bal = ser.deposit(m, b);
									break;
								} catch (AppException e) {

								}
							}
							System.out.println("Your balance after deposit is:" + bal + "\n\n");

							break;
						}

						case 3: {

							System.out.println("Enter withdraw Amount:");
							double d = sc.nextDouble();
							double x;
							while (true) {
								try {
									x = ser.withdraw(m, d);
									break;
								} catch (AppException e) {

									e.printStackTrace();
								}
							}
							System.out.println("Your Balance after withdraw is :" + x + "\n\n");
							break;
						}
						case 4: {
							double ta;
							double na = 0;

							while (true) {
								
								try {
									System.out.println("Enter tranfer amount:");
									ta = sc.nextDouble();
									ser.validatbalance(ta);
									break;
								} catch (AppException e) {

								}
							}

							System.out.println("Enter phn no of account you want to tranfer money");
							String ph = sc.next();

							try {
								na = ser.fundTransfer(m, ta, ph);
								System.out.println("Your Balance after Transfer:" + na + "\n\n");
							} catch (AppException e) {

							}

							break;
						}

						case 5: {
							ArrayList<String> x = ser.printTransaction(m);

							if (x.size() >= 5) {
								System.out.println("List of last 5 transaction is:\n");
								for (int i = x.size() - 1; i > (x.size() - 6); i--) {
									System.out.println(x.get(i));

								}
							}
							if (x.size() < 5) {
								if (x.size() == 0) {
									System.out.println("There are no transactions done by you.");
									break;
								}
								System.out.println("List of last " + x.size() + " transaction is:\n");
								for (int i = x.size() - 1; i >= 0; i--) {
									System.out.println(x.get(i));
								}
							}
							break;
						}
						case 6:
							System.out.println("Exit");
							break;
						}

					}

				} while (n1 != 6);

				break;

			}
			case 3: {
				System.out.println("Exit");
				break;
			}
			}
		} while (n != 3);
	}
}
