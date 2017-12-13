package com.scp.maven.test.StudentCRUDOperation;

public class InvalidRollNo extends Exception {

	public InvalidRollNo(String message) {
		super(message);
		System.out.println("Invalid Roll No");
	}

	public InvalidRollNo(Exception e) {
		// TODO Auto-generated constructor stub
	}

}
