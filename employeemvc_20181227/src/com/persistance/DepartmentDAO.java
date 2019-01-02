package com.persistance;

import java.util.List;

import com.domain.Department;

public interface DepartmentDAO {
	
	public List<Department> departmentList();
	public int departmentInsert(Department d);
	public int departmentDelete(Department d);
	public int departmentUpdate(Department d);

}
