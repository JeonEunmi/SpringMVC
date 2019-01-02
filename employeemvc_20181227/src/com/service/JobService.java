package com.service;

import java.util.List;

import com.domain.Job;

public interface JobService {

	public List<Job> jobList();
	public int jobInsert(Job j);
	public int jobDelete(Job j);
	public int jobUpdate(Job j);

}
