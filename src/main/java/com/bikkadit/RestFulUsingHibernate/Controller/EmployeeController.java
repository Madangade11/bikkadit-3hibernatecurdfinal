package com.bikkadit.RestFulUsingHibernate.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bikkadit.RestFulUsingHibernate.Model.Employee;
import com.bikkadit.RestFulUsingHibernate.Service.EmpServiceI;
@RestController
public class EmployeeController {
	@Autowired
	public EmpServiceI empServiceI;

	@PostMapping(value = "/addemployee", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		int addEmplyee = empServiceI.addEmplyee(employee);
		System.out.println(addEmplyee);
		return new ResponseEntity<>("id created::" + addEmplyee, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getById/{id}", produces = "application/json")
	public ResponseEntity<Employee> getById(@PathVariable int id) {
		Employee byIdEm = empServiceI.getByIdEm(id);
		return new ResponseEntity<Employee>(byIdEm, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllEM", produces = "application/json")
	public ResponseEntity<List<Employee>> getAllEM() {
		List<Employee> allempdata = empServiceI.getAllempdata();
		return new ResponseEntity<List<Employee>>(allempdata, HttpStatus.OK);
	}

	@GetMapping(value = "/loginCheck/{id}/{name}", produces = "application/json")
	public String loginCheck(@PathVariable int id, @PathVariable String name) {

		Employee findByEmpIDAndEmpName = empServiceI.loginCheck(id, name);

		if (findByEmpIDAndEmpName == null) {

			//return new ResponseEntity<Employee>(findByEmpIDAndEmpName, HttpStatus.NOT_FOUND);
			return "Login Fail";
		}
		else {

		//return new ResponseEntity<Employee>(findByEmpIDAndEmpName, HttpStatus.OK);
		return "Login Success";
		}
	}

	@PutMapping(value = "/updateEmployee", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		Employee employee1 = empServiceI.update(employee);
		System.out.println(employee1);
		return new ResponseEntity<>("id " + employee.getEmpId()+" updated", HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/deleteById/{id}", produces = "application/json")
	public String deleteById(@PathVariable int id) {
		Employee byIdEm = empServiceI.delete(id);
		if(byIdEm!=null) {
			return "Deleted";
		}
		return "Id not Found";
	}
}
