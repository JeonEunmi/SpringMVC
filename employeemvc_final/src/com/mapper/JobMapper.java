package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Job;

public class JobMapper implements RowMapper<Job> {

	@Override
	public Job mapRow(ResultSet rs, int count) throws SQLException {
		Job j = new Job();
		j.setJobId(rs.getString("jobId"));
		j.setJob_title(rs.getString("job_title"));
		j.setMin_basicPay(rs.getInt("min_basicPay"));
		j.setCount_(rs.getInt("count_"));
		return j;
	}

}
