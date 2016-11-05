package org.deepblue.dailyroutine.springmvc.dao;

import java.util.List;

import org.deepblue.dailyroutine.springmvc.configuration.AbstractEntity;
import org.deepblue.dailyroutine.springmvc.model.Task;
import org.springframework.stereotype.Repository;

@Repository("taskDao")
public class TaskDaoImpl implements TaskDao {
	
	public List<Task> findAllTasks() {
		String sql = "SELECT * FROM tasks where deleted = 1 ORDER BY name ASC";
		return AbstractEntity.queryListNoParameter(sql, Task.class);
	}

}
