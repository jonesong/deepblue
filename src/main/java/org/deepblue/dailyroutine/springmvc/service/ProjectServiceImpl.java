package org.deepblue.dailyroutine.springmvc.service;

import java.util.List;

import org.deepblue.dailyroutine.springmvc.dao.ProjectDao;
import org.deepblue.dailyroutine.springmvc.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("proejctService")
@Transactional
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectDao dao;

	public Integer findUserIdByProjectId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Project findByProject(int id, int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Project project) {
		// TODO Auto-generated method stub
		
	}

	public void update(Project project) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public List<Project> findAllProjects(int user_id) {
		return dao.findAllProjects(user_id);
	}

}
