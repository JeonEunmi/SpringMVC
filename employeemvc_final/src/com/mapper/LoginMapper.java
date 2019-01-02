package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Login;

public class LoginMapper implements RowMapper<Login> {

	@Override
	public Login mapRow(ResultSet rs, int count) throws SQLException {
		Login l = new Login();
		l.setId_(rs.getString("id_"));
		return l;
	}

}
