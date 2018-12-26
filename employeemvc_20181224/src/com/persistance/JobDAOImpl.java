package com.persistance;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Job;
import com.mapper.JobMapper;

@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Job> jobList() {
		String sql = "SELECT jobId, job_title, min_basicPay\r\n" + 
				"	    ,(SELECT COUNT(*) FROM employees \r\n" + 
				"	     WHERE jobId = j.jobId) count_\r\n" + 
				"       FROM jobs j\r\n" + 
				"	  ORDER BY jobId";
		return this.jdbcTemplate.query(sql, new JobMapper());
	}
	
	@Override
	public int jobInsert(Job j) {
		String sql = "INSERT INTO jobs (jobId, job_title, min_basicPay)\r\n" + 
				"    VALUES ((SELECT CONCAT('JOB', LPAD(IFNULL(SUBSTR(MAX(jobId), 4), 0) + 1, 2, 0)) \r\n" + 
				"        AS newId FROM jobs J), ?, ?)";
		return this.jdbcTemplate.update(sql, j.getJob_title(), j.getMin_basicPay());
	}

	@Override
	public int jobDelete(Job j) {
		String sql = "DELETE FROM jobs WHERE jobId=?";
		return this.jdbcTemplate.update(sql, j.getJobId());
	}

	@Override
	public int jobUpdate(Job j) {
		String sql = "UPDATE jobs SET job_title=?, min_basicPay=? WHERE jobId=?";
		return this.jdbcTemplate.update(sql, j.getJob_title(), j.getMin_basicPay(), j.getJobId());
	}

}
