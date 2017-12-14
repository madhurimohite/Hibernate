package com.scp.maven.test.StudentCRUDOperation;

import java.util.List;

public class StudentTest {

	public static void main(String[] args) throws Exception {
		
	Student s1=new Student(10, "Madhu", "CSE", 80);	
	Student s2=new Student(11, "Madhu", "CSE", 85);	
	Student s3=new Student(12, "PQR", "CSE", 80);	
    StudOperationConstant studConstant= new StudCRUDImplement();
   
    studConstant.addStudent(s1);
    studConstant.addStudent(s2);
   studConstant.addStudent(s3);
   //System.out.println(studConstant.getStudent(10));
  //studConstant.deleteStudent(11);
   /*s1.setName("mmmm");
   studConstant.updateStudent(s1);
  */
 /* List<Student> list= studConstant.searchStudentWithSomeCriteria(s2,SearchParam.name);
 System.out.println(list);*/
   System.out.println(studConstant.searchStudentWithSomeVargCriteria(s3,SearchParam.rollno));
   //System.out.println(list);
   
}
	
enum SearchParam{
	rollno,
	name,
	branch,
	marks,
	all
}
	
}
