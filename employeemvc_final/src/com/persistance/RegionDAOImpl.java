package com.persistance;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Region;
import com.mapper.RegionMapper;

@Repository("regionDAO")
public class RegionDAOImpl implements RegionDAO {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Region> regionList() {
		String sql = "SELECT regId, reg_name\r\n" + 
				"		    ,(SELECT COUNT(*) FROM employees \r\n" + 
				"		            WHERE regId = r.regId) count_\r\n" + 
				"		    FROM regions r\r\n" + 
				"		    ORDER BY regId";
		return this.jdbcTemplate.query(sql, new RegionMapper());
	}
	
	@Override
	public int regionInsert(Region r) {
		String sql = "INSERT INTO regions (regId, reg_name)\r\n" + 
				"    VALUES ((SELECT CONCAT('REG', LPAD(IFNULL(SUBSTR(MAX(regId), 4), 0) + 1, 2, 0)) \r\n" + 
				"	AS newId FROM regions R), ?)";
		return this.jdbcTemplate.update(sql, r.getReg_name());
	}

	@Override
	public int regionDelete(Region r) {
		String sql = "DELETE FROM regions WHERE regId=?";
		return this.jdbcTemplate.update(sql, r.getRegId());
	}

	@Override
	public int regionUpdate(Region r) {
		String sql = "UPDATE regions SET reg_name=? WHERE regId=?";
		return this.jdbcTemplate.update(sql, r.getReg_name(), r.getRegId());
	}

}
