package org.deepblue.dailyroutine.springmvc.service;

import java.util.List;

import org.deepblue.dailyroutine.springmvc.dao.TaskDao;
import org.deepblue.dailyroutine.springmvc.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao dao;
	
	public List<Task> findAllTasks() {
		return dao.findAllTasks();
	}

}
