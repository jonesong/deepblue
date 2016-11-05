package org.deepblue.dailyroutine.springmvc.dao;

import org.deepblue.dailyroutine.springmvc.model.Login;

public interface LoginDao {

	Login findByUsername(String username);
	
}
