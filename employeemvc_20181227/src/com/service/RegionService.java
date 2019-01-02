package com.service;

import java.util.List;

import com.domain.Region;

public interface RegionService {

	public List<Region> regionList();
	public int regionInsert(Region r);
	public int regionDelete(Region r);
	public int regionUpdate(Region r);
	
}
