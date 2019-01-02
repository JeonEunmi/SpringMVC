package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int count) throws SQLException {
		Employee e = new Employee();

		e.setEmpId(rs.getString("empId"));
		e.setName_( rs.getString("name_"));
		e.setSsn( rs.getString("ssn"));
		e.setPhone( rs.getString("phone"));
		e.setHiredate( rs.getDate("hiredate"));
		e.setReg_name( rs.getString("reg_name"));
		e.setDept_name( rs.getString("dept_name"));
		e.setJob_title( rs.getString("job_title"));
		e.setBasicpay( rs.getInt("basicpay"));
		e.setExtrapay(rs.getInt("extrapay"));
		e.setPay( rs.getInt("pay"));
		e.setPictureCount( rs.getInt("pictureCount"));
		e.setFilename( rs.getString("filename"));		
		
		return e;
	}

}