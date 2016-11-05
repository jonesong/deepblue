package org.deepblue.dailyroutine.springmvc.configuration;

import lombok.*;

public class Path {
	
	public Path() {
	}
	//Location
	@Getter public static final String loc_login = "/login/";
	@Getter public static final String loc_logout = "/logout/";
	@Getter public static final String loc_user = "/user/";
	@Getter public static final String loc_project = "/project/";
	@Getter public static final String loc_task = "/task/";
	@Getter public static final String loc_module = "/module/";
	//Web Path
	@Getter public static final String NEW_USER = "newuser";
	@Getter public static final String LIST = "list";
	@Getter public static final String EDIT_USER = "edit-user-";
	@Getter public static final String DEL_USER = "delete-user-";
	
	@Getter public static final String NEW_PROJECT = "newproject";
	@Getter public static final String EDIT_PROJECT = "edit-project-";
	@Getter public static final String DEL_PROJECT = "delete-project-";
	
	@Getter public static final String NEW_TASK = "newtask";
	@Getter public static final String EDIT_TASK = "edit-task-";
	@Getter public static final String DEL_TASK = "delete-task-";
	
	@Getter public static final String LOGOUT = "logout";
	
	//Filenames of JSP
	public static final String userslist = "userslist";
	public static final String registration = "registration";
	public static final String registrationsuccess = "registrationsuccess";
	
	public static final String projectslist = "projectslist";
	public static final String taskslist = "taskslist";
	public static final String moduleslist = "moduleslist";
	
	public static final String login = "login";
	public static final String notfound = "notfound";
	
}
