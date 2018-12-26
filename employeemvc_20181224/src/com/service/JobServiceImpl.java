package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Job;
import com.persistance.JobDAO;

@Service("jobService")
public class JobServiceImpl implements JobService {
	
	@Resource(name="jobDAO")
	private JobDAO jobDAO;

	@Override
	public List<Job> jobList() {
		return this.jobDAO.jobList();
	}
	
	@Override
	public int jobInsert(Job j) {
		return this.jobDAO.jobInsert(j);
	}

	@Override
	public int jobDelete(Job j) {
		return this.jobDAO.jobDelete(j);
	}

	@Override
	public int jobUpdate(Job j) {
		return this.jobDAO.jobUpdate(j);
	}

}
