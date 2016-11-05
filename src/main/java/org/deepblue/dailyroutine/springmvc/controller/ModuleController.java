package org.deepblue.dailyroutine.springmvc.controller;

import java.util.List;

import org.deepblue.dailyroutine.springmvc.configuration.Path;
import org.deepblue.dailyroutine.springmvc.model.Module;
import org.deepblue.dailyroutine.springmvc.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(Path.loc_module)
public class ModuleController {

	@Autowired
	ModuleService moduleService;
	
	@RequestMapping(value = { "/", "/" + Path.LIST }, method = RequestMethod.GET)
	public String listModules(ModelMap model) {
		
		List<Module> modules = moduleService.all(1);
		
		model.addAttribute("modules", modules);
		model.put("WebPath", new Path()); // Access application URLs from templates
		return Path.loc_module + Path.moduleslist;
	}
}
