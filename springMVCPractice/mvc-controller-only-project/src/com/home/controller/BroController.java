package com.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * priya: @Controller-used to treat a java class as a controller
 * @RequestMapping: used to provide relative url; 
 * whenever a request with given url-pattern comes to front-contorller (dad-frontcontroller-servlet.xml), it is redirected to it.
 * All the url-mappings are registered with DispatcherServlet
 * @ResponseBody: to write the response in HTTP response body.
 */
@Controller
public class BroController {
	@ResponseBody
	@RequestMapping("/bat")
	public String giveBat() {
		return "Ok, here is bat for you";
	}
}
