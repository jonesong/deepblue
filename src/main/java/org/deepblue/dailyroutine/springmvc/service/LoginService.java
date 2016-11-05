package org.deepblue.dailyroutine.springmvc.service;

import org.deepblue.dailyroutine.springmvc.model.Login;

public interface LoginService {

	Login findByUsername(String username);
	
	boolean isEntryCorrect(String username, String password);
}
