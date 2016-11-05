package org.deepblue.dailyroutine.springmvc.dao;

import java.util.List;

import org.deepblue.dailyroutine.springmvc.model.Project;

import org.knowm.yank.Yank;
import org.springframework.stereotype.Repository;

@Repository("projectDao")
public class ProjectDaoImpl implements ProjectDao{

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
		Object[] params = new Object[] { user_id };
		String SQL = "SELECT * FROM PROJECTS WHERE USER_ID = ?";
		return Yank.queryBeanList(SQL, Project.class, params);
	}

}
