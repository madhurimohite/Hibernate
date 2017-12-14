package com.scp.maven.test.StudentCRUDOperation;

import java.util.List;

import org.hibernate.Session;


public interface StudOperationConstant {
	
	public Student getStudent(int rno) throws Exception;
	public boolean addStudent(Student s) throws Exception;
	public boolean deleteStudent(int rno) throws Exception;
	public boolean updateStudent(Student s) throws Exception;
	public List<Student> getAllStudent(Session session) throws Exception;
	//public Student searchRecordByRollNo(Student s,int rno) throws Exception;
	//public List<Student> searchStudentWithSomeCriteria(Student s,StudentTest.SearchParam searchParam) throws Exception;

	public List<Student> searchStudentWithSomeVargCriteria(Student s,StudentTest.SearchParam... searchParam) throws Exception;

	}


