package org.deepblue.dailyroutine.springmvc.dao;

import org.deepblue.dailyroutine.springmvc.model.Login;
import org.knowm.yank.Yank;
import org.springframework.stereotype.Repository;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

	public Login findByUsername(String username) {
		Object[] params = new Object[] { username };

		String sqlKey = "SELECT * FROM Users WHERE username = ?";
		return Yank.queryBeanSQLKey(sqlKey, Login.class, params);
	}

}
