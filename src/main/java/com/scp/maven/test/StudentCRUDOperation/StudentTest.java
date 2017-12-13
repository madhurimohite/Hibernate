package com.scp.maven.test.StudentCRUDOperation;

public class StudentTest {

	public static void main(String[] args) throws InvalidRollNo {
		
	Student s1=new Student(10, "Madhu", "CSE", 80);	
	Student s2=new Student(11, "Madhu", "CSE", 85);	
	Student s3=new Student(12, "PQR", "CSE", 90);	
    StudOperationConstant studConstant= new StudCRUDImplement();
   
    studConstant.addStudent(s1);
    studConstant.addStudent(s2);
   studConstant.addStudent(s3);
  //  System.out.println(studConstant.getStudent(10));
  // studConstant.deleteStudent(11);
   // studConstant.updateStudent(12,"Priya");
   // studConstant.getAllStudent();
   // studConstant.searchRecordByRollNo(s2,11);
    studConstant.searchRecordByName(s2,"Madhu");
}
}
