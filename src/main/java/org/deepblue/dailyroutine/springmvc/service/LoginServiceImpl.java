package org.deepblue.dailyroutine.springmvc.service;

import org.deepblue.dailyroutine.springmvc.dao.LoginDao;
import org.deepblue.dailyroutine.springmvc.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao dao;

	public Login findByUsername(String username) {
		Login login = dao.findByUsername(username);
		return login;
	}

	public boolean isEntryCorrect(String username, String password) {
		Login login = findByUsername(username);
		return ( login.getPassword().equals(password) );
	}

}
