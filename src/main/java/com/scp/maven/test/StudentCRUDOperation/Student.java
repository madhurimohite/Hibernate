package com.scp.maven.test.StudentCRUDOperation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Student")
public class Student {

@Id
@Column(name="rno")
private int rollNo;

@Column
private String name;
@Column
private String branch;
@Column
private int marks;

public int getRollNo() {
	return rollNo;
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public void setRollNo(int rollNo) {
	this.rollNo = rollNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
public Student(int rollNo, String name, String branch, int marks) {
	super();
	this.rollNo = rollNo;
	this.name = name;
	this.branch = branch;
	this.marks = marks;
}
@Override
public String toString() {
	return "Student [rollNo=" + rollNo + ", name=" + name + ", branch=" + branch + ", marks=" + marks + "]";
}


}

