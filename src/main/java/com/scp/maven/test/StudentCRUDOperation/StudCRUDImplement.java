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
import com.scp.maven.test.StudentCRUDOperation.StudentTest.SearchParam;

public class StudCRUDImplement implements StudOperationConstant {
	Session session = HibernetUtil.getSessionFactory().openSession();
	/*
	 * 
	 * 
	 * 
	 */
	private void resourceCleanupActivities(Session session, Transaction trac) {
		if(null!=trac)
			trac.commit();
		if(null!=session)
			session.close();
	}
/*
 * 
 * 
 *
 */
		private void checkForNullFields(Student s) throws MyException {

			if (null == s || null == s.getName() || s.getName().trim().length()<=1 ||
				null == s.getBranch() || s.getBranch().trim().length()<=1 ||
			     s.getMarks() <=0) 
			{
				throw new MyException("Book object OR it's fields cann't be null");
			}
		}
	
/*
 * 
 * 
 * 
 * 
 *  */
		public boolean addStudent(Student s) throws com.scp.maven.test.StudentCRUDOperation.MyException {
		checkForNullFields(s);
		Session session = HibernetUtil.getSessionFactory().openSession();
		Transaction trac = session.beginTransaction();
		try {
			session.save(s);
		} catch (Exception e) {
			trac.rollback();
			
			throw new MyException("Error while adding student into db");
		}finally {
			resourceCleanupActivities(session,trac);
		}

		return true;
	}
		

public Student getStudent(int rno) throws com.scp.maven.test.StudentCRUDOperation.MyException {
	if(rno<=0) {
		throw new MyException("Given roll no cannot be zero / doesnt exist in db");
	}

	Student s=null;
	Session session = HibernetUtil.getSessionFactory().openSession();
	Transaction trac = session.beginTransaction();
	try {
		s= (Student) session.get(Student.class, rno);
	} catch (Exception e) {
		trac.rollback();
		throw new MyException("Error while adding student into db");
	}
	return s;

}


	public boolean deleteStudent(int rno) throws com.scp.maven.test.StudentCRUDOperation.MyException {
		if(rno<=0 ||null==getStudent(rno)) {
			throw new MyException("Given roll no cannot be zero / doesnt exist in db");
		}
		
		Session session = HibernetUtil.getSessionFactory().openSession();
		Transaction trac = session.beginTransaction();
		try {
			session.delete(getStudent(rno));
		} catch (Exception e) {
			trac.rollback();
			throw new MyException("Error while adding student into db");
		}finally {
			resourceCleanupActivities(session,trac);
		}
		return true;
	}

	public boolean updateStudent(Student s) throws Exception {
		checkForNullFields(s);
		if(null==getStudent(s.getRollNo()))
				{
			throw new MyException("Given roll no doesnt exist so cannot update..!");
		}
		
		Session session = HibernetUtil.getSessionFactory().openSession();
		Transaction trac = session.beginTransaction();
		try {
			session.update(s);
		} catch (Exception e) {
			trac.rollback();
			throw new MyException("Error while updating student into db");
		}finally {
			resourceCleanupActivities(session,trac);
		}
		return true;
	}

	public List<Student> getAllStudent(Session session) throws com.scp.maven.test.StudentCRUDOperation.MyException {
		List<Student> listOfStud =null;
		try {
			listOfStud = session.createQuery("from Student").list();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new MyException("Error while adding sudent into db");
		}
		return listOfStud;
	}
/*	public Student searchRecordByRollNo(Student s,int rno) {
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

	
*/

/*	public List<Student> searchStudentWithSomeCriteria(Student s, StudentTest.SearchParam param) throws com.scp.maven.test.StudentCRUDOperation.MyException {
		checkForNullFields(s);
		List<Student> students = new ArrayList<Student>();
		Session session = HibernetUtil.getSessionFactory().openSession();
		Transaction trac = session.beginTransaction();
		try {
			Criteria cr = session.createCriteria(Student.class);
			switch(param) {
				case rollno:
				
					students.add((Student) session.get(Student.class,s.getRollNo()));
					break;
				case name:
					cr.add(Restrictions.eq("name",s.getName()));
					students=cr.list();
					break;
				case branch:
					cr.add(Restrictions.eq("branch",s.getBranch()));
					students=cr.list();
					break;
				case marks:
					cr.add(Restrictions.eq("marks",s.getMarks()));
					students= cr.list();
					break;
				case all:
					students=getAllStudent(session);
					break;
				default :
					throw new MyException("Invalid search criteria..!");
			}
							
		} catch (Exception e) {
			trac.rollback();
			throw new MyException("Error while getting book with criteria from db");
		}
		return students;
	}*/
	/*public Student searchRecordByRollNo(Student s, int rno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
*/
	public List<Student> searchStudentWithSomeVargCriteria(Student s, SearchParam... searchParam) throws Exception {
		checkForNullFields(s);
		List<Student> students = new ArrayList<Student>();
		Session session = HibernetUtil.getSessionFactory().openSession();
		Transaction trac = session.beginTransaction();
		try {
			Criteria cr = session.createCriteria(Student.class);
			for(StudentTest.SearchParam param: searchParam){
				//cr.add(Restrictions.eq("rollno", s.getRollNo()),Restrictions.eq("name",s.getName()),Restrictions.eq("branch",s.getBranch()),Restrictions.eq("marks",s.getMarks()));
				if(param == SearchParam.rollno){
					students.add((Student) session.get(Student.class,s.getRollNo()));
					resourceCleanupActivities(session, trac);
					return students;
				}
				if(param == SearchParam.name){
					cr.add(Restrictions.eq("name",s.getName()));		
				}
				if(param == SearchParam.branch){
					cr.add(Restrictions.eq("branch",s.getBranch()));	
				}
				if(param == SearchParam.marks){
					cr.add(Restrictions.eq("marks",s.getMarks()));	
					
				}
				students=cr.list();
				resourceCleanupActivities(session, trac);
				return students;
				
			}
			
			
		} catch (Exception e) {
		//	trac.rollback();
			throw new MyException("Error while getting student with criteria from db");
		}
		return students;
	}
	
}
