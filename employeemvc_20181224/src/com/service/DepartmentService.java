package com.service;

import java.util.List;

import com.domain.Department;

public interface DepartmentService {

	public List<Department> departmentList();
	public int departmentInsert(Department d);
	public int departmentDelete(Department d);
	public int departmentUpdate(Department d);
	
}
