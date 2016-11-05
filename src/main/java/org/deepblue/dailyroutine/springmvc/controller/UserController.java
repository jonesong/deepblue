package org.deepblue.dailyroutine.springmvc.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import org.deepblue.dailyroutine.springmvc.configuration.Path;
import org.deepblue.dailyroutine.springmvc.model.User;
import org.deepblue.dailyroutine.springmvc.service.UserService;

@Controller
@RequestMapping(Path.loc_user)
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	MessageSource messageSource;
	
	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/", "/" + Path.LIST }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.put("WebPath", new Path()); // Access application URLs from templates
		return Path.loc_user + Path.userslist;
	}

	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/" + Path.NEW_USER }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		model.put("WebPath", new Path()); // Access application URLs from templates
		return Path.loc_user + Path.registration;
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/" + Path.NEW_USER }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			model.addAttribute("undo", true); //to make label button changed to undo
			return Path.loc_user + Path.registration;
		}

		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		if(!userService.isUsernameUnique(user.getId(), user.getUsername())){
			FieldError usernameError =new FieldError("user","username",messageSource.getMessage("non.unique.userId", new String[]{user.getUsername()}, Locale.getDefault()));
		    result.addError(usernameError);
			return Path.loc_user + Path.registration;
		}
		
		userService.saveUser(user);

		model.addAttribute("success", user.getFirst_name() + " "+ user.getLast_name());
		model.addAttribute("newuser", true); //to make label saved instead of updated
		model.put("WebPath", new Path()); // Access application URLs from templates
		return Path.loc_user + Path.registrationsuccess;
	}


	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/" + Path.EDIT_USER + "{username}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String username, ModelMap model) {
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.put("WebPath", new Path()); // Access application URLs from templates
		return Path.loc_user + Path.registration;
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/" + Path.EDIT_USER + "{username}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String username) {

		if (result.hasErrors()) {
			model.addAttribute("undo", true); //to make label button changed to undo
			model.addAttribute("edit", true); //to make the label button Update instead of register
			return Path.loc_user + Path.registration;
		}

		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/


		userService.updateUser(user);

		model.addAttribute("success", user.getFirst_name() + " "+ user.getLast_name());
		model.addAttribute("newuser", false);
		model.put("WebPath", new Path()); // Access application URLs from templates
		return Path.loc_user + Path.registrationsuccess;
	}

	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/" + Path.DEL_USER + "{username}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String username, ModelMap model) {
		userService.deleteUserByUsername(username);
		
		return "redirect:" + Path.loc_user + Path.LIST;
	}
	
}
