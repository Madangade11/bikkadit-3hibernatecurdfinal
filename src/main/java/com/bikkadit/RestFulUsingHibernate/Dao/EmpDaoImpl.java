package com.bikkadit.RestFulUsingHibernate.Dao;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bikkadit.RestFulUsingHibernate.Model.Employee;
@Repository
public class EmpDaoImpl implements EmpDaoI {
	@Autowired
	public SessionFactory sf;
	
	@Override
	public int addEmplyee(Employee em) {
		Session session = sf.openSession();
		session.beginTransaction();
			int id = (int) session.save(em);
		session.getTransaction().commit();
		return id;
	}

	@Override
	public Employee getByIdEm(int id) {
		Session session = sf.openSession();
		Employee employee = session.get(Employee.class, id);
		return employee;
	}

	@Override
	public List<Employee> getAllempdata() {
		Session session = sf.openSession();
		String hql="from Employee";
		Query query = session.createQuery(hql);
		List  list = query.getResultList();
		
		return list;
	}

	@Override
	public Employee loginCheck(int id, String name) {
		Session session = sf.openSession();
		String hql="from Employee";
		Query query = session.createQuery(hql);
		List<Employee> emp = query.getResultList();
		
		for(Employee emp1:emp) {
			if((emp1.getEmpId()==id) && (emp1.getEmpName().equals(name))) {
				return emp1;
			}
		}
		return null;
		
	}

	@Override
	public Employee update(Employee employee) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(employee);
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sf.openSession();
		Employee employee1 = session2.get(Employee.class, employee.getEmpId());
		session2.close();
		return employee1;
	}

	@Override
	public Employee delete(int uid) {
		Session session = sf.openSession();
		session.beginTransaction();
		Employee id = session.get(Employee.class, uid);
		if(id!=null) {
			session.delete(id);
			session.getTransaction().commit();
			session.close();
		}
		return id;
	}

}
