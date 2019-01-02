package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Employee;
import com.persistance.EmployeeDAO;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Resource(name="employeeDAO")
	private EmployeeDAO employeeDAO;
	
	@Override
	public List<Employee> list() {
		return this.employeeDAO.list();
	}

	@Override
	public int totalcount() {
		return this.employeeDAO.totalcount();
	}

	@Override
	public int add(Employee emp) {
		return this.employeeDAO.add(emp);
	}

}
