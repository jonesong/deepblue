package org.deepblue.dailyroutine.springmvc.dao;

import java.util.List;

import org.deepblue.dailyroutine.springmvc.model.Module;

public interface ModuleDao {

	List<Module> all(Integer user_id);
	
	Integer getUserIdbyModuleId(Integer id);
	
	List allNames(Integer user_id);
	
	Module findId(String id);
}
