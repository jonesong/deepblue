package org.deepblue.dailyroutine.springmvc.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import org.deepblue.dailyroutine.springmvc.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	public User findById(int id) {
		User user = getByKey(id);
		return user;
	}

	public User findByUsername(String username) {
		System.out.println("USERNAME : "+username);
		try{
			User user = (User) getEntityManager()
					.createQuery("SELECT u FROM User u WHERE u.username LIKE :username")
					.setParameter("username", username)
					.getSingleResult();
			return user; 
		}catch(NoResultException ex){
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		List<User> users = getEntityManager()
				.createQuery("SELECT u FROM User u WHERE u.deleted = '1' ORDER BY u.firstName ASC")
				.getResultList();
		return users;
	}

	public void save(User user) {
		persist(user);
	}

	public void deleteByUsername(String username) {
		User user = (User) getEntityManager()
				.createQuery("SELECT u FROM User u WHERE u.username LIKE :username")
				.setParameter("username", username)
				.getSingleResult();
		delete(user);
	}

}
