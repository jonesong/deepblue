package org.deepblue.dailyroutine.springmvc.service;

import java.util.List;

import org.deepblue.dailyroutine.springmvc.model.Project;

public interface ProjectService {

	Integer findUserIdByProjectId(int id);

	Project findByProject(int id, int user_id);

	void save(Project project);

	void update(Project project);

	void delete(int id);

	List<Project> findAllProjects(int user_id);
}
