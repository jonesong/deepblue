package org.deepblue.dailyroutine.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.deepblue.dailyroutine.springmvc.dao.UserDao;
import org.deepblue.dailyroutine.springmvc.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	public User findById(int id) {
		return dao.findById(id);
	}

	public User findByUsername(String username) {
		User user = dao.findByUsername(username);
		return user;
	}

	public void saveUser(User user) {
		dao.save(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setId(user.getId());
			entity.setPassword(user.getPassword());
			entity.setFirst_name(user.getFirst_name());
			entity.setLast_name(user.getLast_name());
			//status & deleted have default values of 1
		}
	}
	
	/**
	 * Do not delete the record physically but making deleted field flag into 0.
	 */
	public void deleteUserByUsername(String username) {
//		dao.deleteByUsername(username);
		User entity = dao.findByUsername(username);
		if(entity!=null){
			entity.setDeleted('0');
		}
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public boolean isUsernameUnique(Integer id, String username) {
		User user = findByUsername(username);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	
	public boolean isEntryCorrect(String username, String password) {
		User user = findByUsername(username);
		return ( user == null || !user.getPassword().equals(password) );
	}
	
	public int findIdbyUsername(String username) {
		User user = findByUsername(username);
		return user.getId();
	}
}
