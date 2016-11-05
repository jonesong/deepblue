package org.deepblue.dailyroutine.springmvc.configuration;

import org.springframework.ui.ModelMap;

public class RequestUtil {
	
	public static boolean removeSessionAttrCurrentUser(ModelMap model) {
        Object currentUser = model.addAttribute("currentUser");
        model.remove("currentUser");
        return currentUser != null;
    }

	public static boolean removeSessionAttrLoggedOut(ModelMap model) {
		Object loggedOut = null;
		if (model != null){
			loggedOut = model.get("loggedOut");
			model.remove("loggedOut");
		}
		return loggedOut != null;
    }
	
}
