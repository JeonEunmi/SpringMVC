package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Region;
import com.persistance.RegionDAO;

@Service("regionService")
public class RegionServiceImpl implements RegionService {
	
	@Resource(name="regionDAO")
	private RegionDAO regionDAO;

	@Override
	public List<Region> regionList() {
		return this.regionDAO.regionList();
	}

	@Override
	public int regionInsert(Region r) {
		return this.regionDAO.regionInsert(r);
	}

	@Override
	public int regionDelete(Region r) {
		return this.regionDAO.regionDelete(r);
	}

	@Override
	public int regionUpdate(Region r) {
		return this.regionDAO.regionUpdate(r);
	}
}
