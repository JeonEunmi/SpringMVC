package com.persistance;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Employee;
import com.mapper.EmployeeMapper;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	/*
	//1Â÷ ºä
	CREATE OR REPLACE VIEW empView
	AS
	SELECT E.empId, name_, ssn, phone, hiredate
			, reg_name, dept_name, job_title, basicpay, extrapay
			, (basicpay + extrapay) pay
			, (SELECT COUNT(*) FROM employeePictureList
					WHERE empId = E.empId) pictureCount
			FROM employees E, departments D, jobs j, regions R
			WHERE E.deptid = D.deptid
				AND E.jobid = j.jobid
				AND E.regid = R.regid;

	//2Â÷ ºä
	CREATE OR REPLACE VIEW picEmpView
	AS
	SELECT e.empId, name_, ssn, phone, hiredate
		, reg_name, dept_name, job_title, basicpay, extrapay,  pay
	    , pictureCount, filename
		FROM empView e LEFT JOIN employeePictureList ep
	    ON e.empId = ep.empId;
	   
	//2Â÷ ºä¸¦ ÀÌ¿ëÇÑ SELECT Äõ¸®    
	SELECT empId, name_, ssn, phone, hiredate
		, reg_name, dept_name, job_title, basicpay, extrapay,  pay
	    , pictureCount, filename
		FROM picEmpView
		ORDER BY empId;
	*/	
	
	
	@Override
	public List<Employee> list() {
		
		String sql = "SELECT empId, name_, ssn, phone, hiredate\r\n" + 
				"	, reg_name, dept_name, job_title, basicpay, extrapay,  pay\r\n" + 
				"    , pictureCount, filename\r\n" + 
				"	FROM picEmpView\r\n";
		sql += " ORDER BY empId";
		
		return this.jdbcTemplate.query(sql, new EmployeeMapper());
		
	}

	@Override
	public int totalcount() {
		
		String sql = "SELECT COUNT(*) count_\r\n" + 
				"		    FROM picEmpView";
		
		return this.jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public int add(Employee emp) {
		String sql = "INSERT INTO employees  (empId, name_, ssn, hiredate, phone\r\n"
				+ "    , regId, deptId, jobId, basicpay, extrapay)\r\n"
				+ "    VALUES ((SELECT CONCAT('EMP', LPAD(IFNULL(SUBSTR(MAX(empId), 4), 0) + 1, 3, 0)) \r\n"
				+ "        AS newId FROM employees E), ?, ?, ?\r\n"
				+ "        , ?, ?, ?, ?, ?, ?)";
		return this.jdbcTemplate.update(sql
				, emp.getName_()
				, emp.getSsn()
				, emp.getHiredate()
				, emp.getPhone()
				, emp.getRegId()
				, emp.getDeptId()
				, emp.getJobId()
				, emp.getBasicpay()
				, emp.getExtrapay());
	}
	
}
