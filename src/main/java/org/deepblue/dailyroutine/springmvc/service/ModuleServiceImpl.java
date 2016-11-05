package org.deepblue.dailyroutine.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.deepblue.dailyroutine.springmvc.dao.ModuleDao;
import org.deepblue.dailyroutine.springmvc.model.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("moduleService")
@Transactional
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleDao dao;

	public List<Module> all(Integer user_id) {
		return dao.all(user_id);
	}

	public Integer getUserIdbyModuleId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List allNames(Integer user_id) {
		return dao.allNames(user_id);
	}

	public List<String> userPage(Object user_id) {
		List<String> blank = new ArrayList<String>();
		blank.add("0");
		if (user_id != null) {
			List db = allNames((Integer) user_id);
			List<String> listA = new ArrayList<String>();
			for (int x = 0; x < db.size(); x++) {
				listA.add(db.get(x).toString().toLowerCase());
			}
			return listA;
		}
		return blank;
	}

	public Module findId(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
