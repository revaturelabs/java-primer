package com.revature.view;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("viewController")
public class ViewControllerAlpha implements ViewController {

	private static Logger logger = Logger.getLogger(ViewControllerAlpha.class);
	
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public String index() {
		logger.info("Getting index HTML from View Controller.");
		return "index";
	}
}
