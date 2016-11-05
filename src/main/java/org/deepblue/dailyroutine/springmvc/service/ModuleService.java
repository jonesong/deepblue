package org.deepblue.dailyroutine.springmvc.service;

import java.util.List;

import org.deepblue.dailyroutine.springmvc.model.Module;

public interface ModuleService {

	List<Module> all(Integer user_id);
	
	Integer getUserIdbyModuleId(Integer id);
	
	List allNames(Integer user_id);
	
	List<String> userPage(Object user_id);
	
	Module findId(String id);
}
