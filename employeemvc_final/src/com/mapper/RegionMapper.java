package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Region;

public class RegionMapper implements RowMapper<Region> {

	@Override
	public Region mapRow(ResultSet rs, int count) throws SQLException {
		Region r = new Region();
		r.setRegId(rs.getString("regId"));
		r.setReg_name(rs.getString("reg_name"));
		r.setCount_(rs.getInt("count_"));
		return r;
	}

}
