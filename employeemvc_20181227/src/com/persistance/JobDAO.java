package com.persistance;

import java.util.List;

import com.domain.Job;

public interface JobDAO {
	
	public List<Job> jobList();
	public int jobInsert(Job j);
	public int jobDelete(Job j);
	public int jobUpdate(Job j);

}
