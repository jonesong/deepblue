package org.deepblue.dailyroutine.springmvc.controller;

import java.util.List;
import java.util.Properties;

import org.deepblue.dailyroutine.springmvc.configuration.Path;
import org.deepblue.dailyroutine.springmvc.model.Project;
import org.deepblue.dailyroutine.springmvc.service.ProjectService;
import org.knowm.yank.PropertiesUtils;
import org.knowm.yank.Yank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(Path.loc_project)
public class ProjectController extends CommonController {

	@Autowired
	ProjectService projectService;
	
	// DB Properties
	Properties dbProps = PropertiesUtils.getPropertiesFromClasspath("MYSQL_DB.properties");
			
	@RequestMapping(value = { "/", "/" + Path.LIST }, method = RequestMethod.GET)
	public String listProjects(ModelMap model) {

		model = loadToExisting(model);
		List<String> isProject = (List<String>) model.get("userPages"); //used to add security for checking		
		if (model.get("currentId") == null || !isProject.contains("project")){ //if enduser input url manually,it will result on this page
			return Path.notfound;
		}
		Yank.setupDefaultConnectionPool(dbProps);
		List<Project> projects = projectService.findAllProjects(Integer.parseInt(model.get("currentId").toString()));
		Yank.releaseDefaultConnectionPool();
		model = addToView(model, "projects", projects);
		return Path.loc_project + Path.projectslist;
	}
}
