package com.scp.maven.test.StudentCRUDOperation;

import java.util.List;

public interface StudOperationConstant {
	
	Student getStudent(int rno) throws InvalidRollNo;
	boolean addStudent(Student s);
	boolean deleteStudent(int rno);
	Student updateStudent(int rno,String nm);
	List<Student> getAllStudent();
    Student searchRecordByRollNo(Student s,int rno);
    List<Student> searchRecordByName(Student s,String name);
}
