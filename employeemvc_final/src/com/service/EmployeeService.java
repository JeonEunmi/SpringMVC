package com.service;

import java.util.List;

import com.domain.Employee;

public interface EmployeeService {
	
	public List<Employee> list();

	public int totalcount();
	
	public int add(Employee emp);
	
}
