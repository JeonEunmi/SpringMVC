package com.persistance;

import java.util.List;

import com.domain.Employee;

public interface EmployeeDAO {
	
	public List<Employee> list();
	
	public int totalcount();

	public int add(Employee emp);
	
}
