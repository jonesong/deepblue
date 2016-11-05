package org.deepblue.dailyroutine.springmvc.dao;

import java.util.List;

import org.deepblue.dailyroutine.springmvc.model.Task;

public interface TaskDao {

	List<Task> findAllTasks();
}
