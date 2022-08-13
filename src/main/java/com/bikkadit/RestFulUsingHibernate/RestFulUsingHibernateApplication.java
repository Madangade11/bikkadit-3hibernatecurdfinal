package com.bikkadit.RestFulUsingHibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.bikkadit.RestFulUsingHibernate.Dao.EmpDaoImpl;
import com.bikkadit.RestFulUsingHibernate.Model.Employee;
import com.bikkadit.RestFulUsingHibernate.Service.EmpServiceI;

@SpringBootApplication
public class RestFulUsingHibernateApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(RestFulUsingHibernateApplication.class, args);
		EmpServiceI bean = context.getBean(EmpServiceI.class);
		EmpDaoImpl bean2 = context.getBean(EmpDaoImpl.class);
		
	}

}
