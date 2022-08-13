package com.bikkadit.RestFulUsingHibernate.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bikkadit.RestFulUsingHibernate.Dao.EmpDaoI;
import com.bikkadit.RestFulUsingHibernate.Model.Employee;
@Service
public class EmpServiceImpl implements EmpServiceI {
	@Autowired
	public EmpDaoI empDaoI;
	@Override
	public int addEmplyee(Employee em) {
		int i = empDaoI.addEmplyee(em);
		return i;
	}

	@Override
	public Employee getByIdEm(int id) {
		Employee byIdEm = empDaoI.getByIdEm(id);
		return byIdEm;
	}

	@Override
	public List<Employee> getAllempdata() {
		List<Employee> allempdata = empDaoI.getAllempdata();
		return allempdata;
	}

	@Override
	public Employee loginCheck(int id, String name) {
		Employee loginCheck = empDaoI.loginCheck(id, name);
		return loginCheck;
	}

	@Override
	public Employee update(Employee employee) {
		Employee employee1 = empDaoI.update(employee);
		return employee1;
	}

	@Override
	public Employee delete(int uid) {
		Employee delete = empDaoI.delete(uid);
		return delete;
	}
}
