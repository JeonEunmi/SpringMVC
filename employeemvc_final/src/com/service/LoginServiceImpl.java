package com.service;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.domain.Login;
import com.persistance.LoginDAO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Resource(name="loginDAO")
	private LoginDAO loginDAO;

	@Override
	public Login login(Login l) throws DataAccessException {
		return this.loginDAO.login(l);
	}

}
