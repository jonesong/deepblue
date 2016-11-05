package org.deepblue.dailyroutine.springmvc.controller;

import java.util.List;

import org.deepblue.dailyroutine.springmvc.configuration.Path;
import org.deepblue.dailyroutine.springmvc.model.Task;
import org.deepblue.dailyroutine.springmvc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(Path.loc_task)
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@RequestMapping(value = { "/", "/" + Path.LIST }, method = RequestMethod.GET)
	public String listTasks(ModelMap model) {
		
		List<Task> tasks = taskService.findAllTasks();
		
		model.addAttribute("tasks", tasks);
		model.put("WebPath", new Path()); // Access application URLs from templates
		return Path.loc_task + Path.taskslist;
	}
}
