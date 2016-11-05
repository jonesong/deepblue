package org.deepblue.dailyroutine.springmvc.service;

import java.util.List;

import org.deepblue.dailyroutine.springmvc.model.User;

public interface UserService {
	
	User findById(int id);
	
	User findByUsername(String username);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserByUsername(String username);

	List<User> findAllUsers(); 
	
	boolean isUsernameUnique(Integer id, String username);

	boolean isEntryCorrect(String username, String password);
	
	int findIdbyUsername(String username);
}