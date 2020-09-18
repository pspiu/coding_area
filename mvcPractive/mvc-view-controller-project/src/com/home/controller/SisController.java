package com.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
/*
 * priya: If we provide RequestMapping @class level, no need to restart server again and again
 */
@RequestMapping("/sis")
public class SisController {
 
	/*
	 * priya: We can have multiple handler methods in a single controller
	 */
	@ResponseBody
	@RequestMapping("/makeup")
	public String giveMakeup() {
		return "Ok, here is makeup for you";
	}
	
	@ResponseBody
	@RequestMapping("/books")
	public String giveBooks() {
		return "Ok, here are books for you";
	}
}
