package org.deepblue.dailyroutine.springmvc.controller;

import org.deepblue.dailyroutine.springmvc.configuration.Path;
import org.springframework.ui.ModelMap;

public class CommonController {
	
	private static ModelMap addModel;
	
	protected ModelMap commonView(ModelMap model){
		addModel = model;
		addModel.putIfAbsent("WebPath", new Path()); // Access application URLs from templates	
		return addModel;
	}
	
	protected ModelMap addToView(ModelMap model, String name, Object object){
		//used this method to store new objects
		addModel = model;
		addModel.put(name, object);
		return commonView(addModel);
	}
	
	protected ModelMap loadToExisting(ModelMap model){
		//used this method to additional from different module e.g. addModel has user's info, then ProjectController call this to add the projects' data
		return model.addAllAttributes(addModel);
	}
	
}
