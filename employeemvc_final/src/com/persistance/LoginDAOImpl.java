package com.persistance;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Login;
import com.mapper.LoginMapper;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public Login login(Login l) throws DataAccessException {
		
		String sql = "SELECT id_ FROM login WHERE id_=? AND pw_=?";
		
		return this.jdbcTemplate.queryForObject(sql
					, new LoginMapper()
					, l.getId_(), l.getPw_());
	}

}
