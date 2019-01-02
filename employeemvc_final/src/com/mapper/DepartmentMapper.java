package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Department;

public class DepartmentMapper implements RowMapper<Department> {

	@Override
	public Department mapRow(ResultSet rs, int count) throws SQLException {
		Department d = new Department();
		d.setDeptId(rs.getString("deptId"));
		d.setDept_name(rs.getString("dept_name"));
		d.setCount_(rs.getInt("count_"));
		return d;
	}

}
