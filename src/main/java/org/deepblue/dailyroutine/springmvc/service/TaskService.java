package org.deepblue.dailyroutine.springmvc.service;

import java.util.List;

import org.deepblue.dailyroutine.springmvc.model.Task;

public interface TaskService {

	List<Task> findAllTasks();
}
