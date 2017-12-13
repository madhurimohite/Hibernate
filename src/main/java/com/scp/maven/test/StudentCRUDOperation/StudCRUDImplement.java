package com.scp.maven.test.StudentCRUDOperation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class StudCRUDImplement implements StudOperationConstant {
	Session session = HibernetUtil.getSessionFactory().openSession();

	public Student getStudent(int rno) throws InvalidRollNo {
		Student s = new Student();
		s = (Student) session.load(Student.class, rno);
		throw new InvalidRollNo("Invalid Student Roll No");

	}

	public boolean addStudent(Student s) {
		// Session session=HibernetUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		session.save(s);
		trans.commit();
		return true;
	}

	public boolean deleteStudent(int rno) {
		// Session session=HibernetUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();

		Student s = (Student) session.get(Student.class, rno);
		session.delete(s);
		// System.out.println("Deleted Record :"+ rno);
		trans.commit();
		// session.close();
		return true;
	}

	public Student updateStudent(int rno, String name) {
		Student s2 = (Student) session.get(Student.class, rno);
		s2.setName(name);
		return null;
	}

	public List<Student> getAllStudent() {
		Transaction trans = session.beginTransaction();
		org.hibernate.Query query = session.createQuery("from Student");
		java.util.List list = query.list();
		System.out.println(list);
		trans.commit();
		return null;
	}

	public Student searchRecordByRollNo(Student s,int rno) {
	//	List<Student> list = new ArrayList<Student>();
		Transaction trans = session.beginTransaction();
		 Criteria criteria = session.createCriteria(Student.class);
		             criteria.add(Restrictions.eq("rollNo", rno));
		             Student student = (Student) criteria.uniqueResult();
		             if (s!=null) {
		                 System.out.println("Student found:");
		                 System.out.println(s.getRollNo());
		             }
		             trans.commit();
					return student ;

	}

	public List<Student> searchRecordByName(Student s, String name) {
		Transaction trans = session.beginTransaction();
		org.hibernate.Query query = session.createQuery("from Student");
		java.util.List list = query.list();		
		 Criteria criteria = session.createCriteria(Student.class);
         criteria.add(Restrictions.eq("name", name));
         List l1=criteria.list();
         for (Object object : l1) {
		
        	 System.out.println(object);
		}
         //Student student = (Student) criteria.uniqueResult();
               trans.commit();
		return l1 ;
		 
		
	}

}
