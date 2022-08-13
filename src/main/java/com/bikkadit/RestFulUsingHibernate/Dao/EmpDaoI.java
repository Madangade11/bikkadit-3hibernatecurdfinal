package com.bikkadit.RestFulUsingHibernate.Dao;

import java.util.List;

import com.bikkadit.RestFulUsingHibernate.Model.Employee;

public interface EmpDaoI {

	public int addEmplyee(Employee em);

	public Employee getByIdEm(int id);

	public List<Employee> getAllempdata();

	public Employee loginCheck(int id, String name);

	public Employee update(Employee employee);

	public Employee delete(int uid);
}
