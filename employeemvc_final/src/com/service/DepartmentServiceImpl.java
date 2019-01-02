package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Department;
import com.persistance.DepartmentDAO;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Resource(name="departmentDAO")
	private DepartmentDAO departmentDAO;

	@Override
	public List<Department> departmentList() {
		return this.departmentDAO.departmentList();
	}
	
	@Override
	public int departmentInsert(Department d) {
		return this.departmentDAO.departmentInsert(d);
	}

	@Override
	public int departmentDelete(Department d) {
		return this.departmentDAO.departmentDelete(d);
	}

	@Override
	public int departmentUpdate(Department d) {
		return this.departmentDAO.departmentUpdate(d);
	}

}
