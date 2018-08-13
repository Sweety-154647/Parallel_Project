package com.cg.pra.test;

import org.junit.Test;

import com.cg.pra.appException.AppException;
import com.cg.pra.beans.Account;
import com.cg.pra.service.ServiceImpl;
import com.cg.pra.ui.MainUI;

import org.junit.Ignore;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TestTest {
	ServiceImpl s = new ServiceImpl();
	String message = "Robert";
	MainUI m = new MainUI();

	@Test
	public void testName() {
		//user Name format is correct that is first character here is capital
		String t = "true";
		try {
			s.validateName("Apple");
		} catch (AppException e) {
			t = "false";
		}
		assertEquals("true", t);
	}

	@Test
	public void testName1() {
		//user Name format is incorrect that is first character here is not  capital
		String t = "true";
		try {
			s.validateName("apple");
		} catch (AppException e) {
			t = "false";
		}
		assertEquals("false", t);
	}

	@Test
	public void testphn() {
		//here phone number is 10digit long and hence it is correct
		String t = "true";
		try {
			s.validatephn("1234567890");
		} catch (AppException e) {
			t = "false";
		}
		assertEquals("true", t);
	}

	@Test
	public void testphn1() {
		//here phone number is less than 10 digit and hence in correct
		String t = "true";
		try {
			s.validatephn("123456");
		} catch (AppException e) {
			t = "false";
		}
		assertEquals("false", t);
	}

	@Test
	public void testmailID() {
		//here mailId is in format raj@gmail.com and hence correct
		String t = "true";
		try {
			s.validatemailId("rajesh@gmail.com");
		} catch (AppException e) {
			t = "false";
		}
		assertEquals("true", t);
	}

	@Test
	public void testmailID1() {
		//here mailId is not in format raj@gmail.com and hence incorrect
		String t = "true";
		try {
			s.validatemailId("raje@gmail");
		} catch (AppException e) {
			t = "false";
		}
		assertEquals("false", t);
	}

	@Test
	public void testpass() {
		//here password format is rajs@1and hence correct 
		String t = "true";
		try {
			s.validatpassword("rajes@123");
		} catch (AppException e) {
			t = "false";
		}
		assertEquals("true", t);
	}

	@Test
	public void testpass1() {
		//here password format is not rajs@1 and hence incorrect 
		String t = "true";
		try {
			s.validatpassword("rajes123");
		} catch (AppException e) {
			t = "false";
		}
		assertEquals("false", t);
	}

	@Test
	public void testbal() {
		//here balance is greter than 0 and hence correct
		String t = "true";
		try {
			s.validatbalance(200.0);
		} catch (AppException e) {
			t = "false";
		}
		assertEquals("true", t);
	}

	@Test
	public void testbal1() {
		//here balance is not greter than 0 and hence incorrect
		String t = "true";
		try {
			s.validatbalance(0);
		} catch (AppException e) {
			t = "false";
		}
		assertEquals("false", t);
	}

	@Test
	public void testvalUserPass() {
//here user id phone number and password matches database and hence  correct
		boolean t = true;
		try {
			s.valUserPass("9010210131", "vaish@1");

		} catch (AppException e) {
			t = false;
		}
		assertEquals(true, t);
	}

	@Test
	public void testvalUserPass1() {
		//here user id phone number and password  does not matches
		//as password database and hence  incorrect 
		boolean t = true;
		try {
			s.valUserPass("9010210131", "vaih@1");

		} catch (AppException e) {
			t = false;
		}
		assertEquals(false, t);
	}

	@Test
	public void testdeposit() {
//here deposit amount is greater than zero and hence correct
		double d = 0;
		try {
			d = s.deposit(s.acc.getHash().get("9010210131"), 100);

		} catch (AppException e) {

		}
		assertEquals(300, (int) d);
	}

	@Test
	public void testdeposit1() {
////here deposit amount should be greater than zero and hence incorrect
		boolean t = true;
		double d1 = 0;
		try {
			d1 = s.deposit(s.acc.getHash().get("9010210131"), 0);

		} catch (AppException e) {
			t = false;
		}
		assertEquals(false, t);
	}
	@Test
	public void testdeposit2() {
//here deposit amount is less than zero and hence incorrect
		boolean t = true;
		double d1 = 0;
		try {
			d1 = s.deposit(s.acc.getHash().get("8685086613"), -1);

		} catch (AppException e) {
			t = false;
		}
		assertEquals(false, t);
	}


	@Test
	public void testwithdraw() {
//here withdraw amount should be greater than zero and hence incorrect
		boolean t = true;
		double d1 = 0;
		try {
			d1 = s.withdraw(s.acc.getHash().get("9010210131"), 0);

		} catch (AppException e) {
			t = false;
		}
		assertEquals(false, t);
	}
	@Test
	public void testwithdraw1() {
		//here withdraw amount should be greater than zero and hence incorrect
		boolean t = true;
		double d1 = 0;
		try {
			d1 = s.withdraw(s.acc.getHash().get("9010210131"), -1);

		} catch (AppException e) {
			t = false;
		}
		assertEquals(false, t);
	}


	@Test
	public void testwithdraw2() {
		//here withdraw amount is greater than zero and hence correct
		boolean t = true;
		double d1 = 0;
		try {
			d1 = s.withdraw(s.acc.getHash().get("9010210131"), 100);

		} catch (AppException e) {
			t = false;
		}
		assertEquals(100, (int) d1);
	}
	
	
	

	@Test
	public void testfundTransfer() {
//here fund transfer amount is greater than zero and hence correct
		boolean t = true;
		double d1 = 0;
		try {
			d1 = s.fundTransfer(s.acc.getHash().get("9010210131"), 100.0, "8685086613");

		} catch (AppException e) {
			t = false;
		}
		assertEquals(100, (int) d1);
	}

	@Test
	public void testfundTransfer1() {
		//here fund transfer amount should  be greater than zero and hence incorrect
		boolean t = true;
		double d1 = 0;
		try {
			d1 = s.fundTransfer(s.acc.getHash().get("9010210131"), 0.0, "8685086613");

		} catch (AppException e) {
			t = false;
		}
		assertEquals(false, t);
	}

	@Test
	public void testfundTransfer2() {
		//here fund transfer amount is greater than zero and 
		//but phone number on which amount is being transfered is not in list and hence incorrect
		boolean t = true;
		double d1 = 0;
		try {
			d1 = s.fundTransfer(s.acc.getHash().get("9010210131"), 100.0, "1234567890");

		} catch (AppException e) {
			t = false;
		}
		assertEquals(false, t);
	}

	@Test
	public void testfundTransfer3() {
		//here fund transfer amount is greater than zero and 
		//but phone number on which amount is being transfered is less than 10 digit and hence incorrect
		boolean t = true;
		double d1 = 0;
		try {
			d1 = s.fundTransfer(s.acc.getHash().get("9010210131"), 100.0, "12345670");

		} catch (AppException e) {
			t = false;
		}
		assertEquals(false, t);
	}
	
	@Test
	public void testfundTransfer4() {
		//here fund transfer amount is greater than zero and 
		//but phone number on which amount is being transfered is same as
		//phone number through which tranfer takes place and hence incorrect
		boolean t = true;
		double d1 = 0;
		try {
			d1 = s.fundTransfer(s.acc.getHash().get("9010210131"), 100.0, "9010210131");

		} catch (AppException e) {
			t = false;
		}
		assertEquals(false, t);
	}
	@Test
	public void testfundTransfer5() {
		//here fund transfer amount is less  than zero and 
		//phone number on which amount is being transfered is same as
		//phone number through which tranfer takes place and hence incorrect
		boolean t = true;
		double d1 = 0;
		try {
			d1 = s.fundTransfer(s.acc.getHash().get("9010210131"), -1.0, "9010210131");

		} catch (AppException e) {
			t = false;
		}
		assertEquals(false, t);
	}
	@Test
	public void testfundTransfer6() {
		//here phone number on which amount is being transfered is in list 
		//but fund transfer amount is less  than zero  and hence incorrect
		boolean t = true;
		double d1 = 0;
		try {
			d1 = s.fundTransfer(s.acc.getHash().get("9010210131"), -1.0, "8685086613");

		} catch (AppException e) {
			t = false;
		}
		assertEquals(false, t);
	}

}