package com.persistance;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Department;
import com.mapper.DepartmentMapper;

@Repository("departmentDAO")
public class DepartmentDAOImpl implements DepartmentDAO {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Department> departmentList() {
		String sql = "SELECT deptId, dept_name\r\n" + 
				"		 , (SELECT COUNT(*) FROM employees WHERE deptId = d.deptId) count_\r\n" + 
				"		 FROM departments d\r\n" + 
				"         ORDER BY deptId";
		return this.jdbcTemplate.query(sql, new DepartmentMapper());
	}
	
	@Override
	public int departmentInsert(Department d) {
		String sql = "INSERT INTO departments (deptId, dept_name)\r\n" + 
				"    VALUES ((SELECT CONCAT('DEPT', LPAD(IFNULL(SUBSTR(MAX(deptId), 5), 0) + 1, 2, 0)) \r\n" + 
				"	AS newId FROM departments D), ?)";
		return this.jdbcTemplate.update(sql, d.getDept_name());
	}

	@Override
	public int departmentDelete(Department d) {
		String sql = "DELETE FROM departments WHERE deptId=?";
		return this.jdbcTemplate.update(sql, d.getDeptId());
	}

	@Override
	public int departmentUpdate(Department d) {
		String sql = "UPDATE departments SET dept_name=? WHERE deptId=?";
		return this.jdbcTemplate.update(sql, d.getDept_name(), d.getDeptId());
	}

}
