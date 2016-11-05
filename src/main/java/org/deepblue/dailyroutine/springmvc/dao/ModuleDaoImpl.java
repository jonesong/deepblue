package org.deepblue.dailyroutine.springmvc.dao;

import java.util.List;

import org.deepblue.dailyroutine.springmvc.configuration.AbstractEntity;
import org.deepblue.dailyroutine.springmvc.model.Module;
import org.springframework.stereotype.Repository;

@Repository("moduleDao")
public class ModuleDaoImpl implements ModuleDao {

	public List<Module> all(Integer user_id) {
		String sql = "SELECT id, user_id, name FROM modules where deleted = 1 and user_id = :str1 ORDER BY name ASC";
		String[] values = { String.valueOf(user_id) };
		return AbstractEntity.queryListMultiParameter(sql, Module.class, values);
	}

	public Integer getUserIdbyModuleId(Integer id) {
		String sql = "SELECT user_id FROM modules where deleted = 1 and id = :str1";
		String[] values = { String.valueOf(id) };
		return AbstractEntity.queryIntegerMultiParameter(sql, values);
	}

	public List allNames(Integer user_id) {
		String sql = "SELECT name FROM modules where deleted = 1 and user_id = :str1 ORDER BY name ASC";
		String[] values = { String.valueOf(user_id) };
		return AbstractEntity.queryListNoParameter(sql, values);
	}

	public Module findId(String id) {
		String sql = "SELECT * FROM modules where deleted = 1 and id = :str1";
		String[] values = { id };
		return (Module) AbstractEntity.queryClassMultiParameter(sql, Module.class, values);
	}

}
