package org.deepblue.dailyroutine.springmvc.controller;

import org.deepblue.dailyroutine.springmvc.configuration.Path;
import org.deepblue.dailyroutine.springmvc.model.User;
import org.deepblue.dailyroutine.springmvc.service.ModuleService;
import org.deepblue.dailyroutine.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(Path.loc_login)
public class LoginController extends CommonController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ModuleService moduleService;

	@RequestMapping(value = { "/", "/" + Path.login }, method = RequestMethod.GET)
	public String serveLoginPage(ModelMap model) {
		User user = new User(); //initialize and is defined modelAttribue in JSP
		model = addToView(model, "user", user);
		return Path.loc_login + Path.login;
	}
	
	@RequestMapping(value = { "/", "/" + Path.login }, method = RequestMethod.POST)
	public String handleLoginPost(@Valid User user, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return Path.loc_login + Path.login;
		}
		
		if (userService.isEntryCorrect(result.getFieldValue("username").toString(), result.getFieldValue("password").toString())){
			model.put("authenticationFailed", true);
			return Path.loc_login + Path.login;
		}
		
		model.remove("user"); //no need and to remove in static addModule 
		model.put("authenticationSucceeded", true);
		model = addToView(model, "currentId", userService.findIdbyUsername(user.getUsername()));
		model = addToView(model, "currentUser", user.getUsername());
		model = addToView(model, "userPages", moduleService.userPage(userService.findByUsername(user.getUsername()).getId()));
		return Path.loc_login + Path.login;
	}
	
	@RequestMapping(value = { "/" + Path.LOGOUT }, method = RequestMethod.GET)
	public String handleLogoutPost(ModelMap model) {
		model.clear();
		return "redirect:" + Path.loc_login;
	}
}
