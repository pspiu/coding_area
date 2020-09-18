package com.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MomController {

	@ResponseBody
	@RequestMapping("/sugar")
	public String giveSugar() {
		return "Ok, here is sugar for you";
	}
}
