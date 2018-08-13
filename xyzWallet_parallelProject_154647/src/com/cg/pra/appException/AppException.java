package com.cg.pra.appException;

//this class is used to define user define exception
public class AppException extends Exception {
	public AppException() {
	}

	public AppException(String s) {
		System.out.println(s);
	}
}
