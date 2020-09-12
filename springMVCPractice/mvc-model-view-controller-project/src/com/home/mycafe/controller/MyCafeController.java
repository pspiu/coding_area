package com.home.mycafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyCafeController {

	@RequestMapping("/cafe")
	public String showWelcomePage(Model model) {
		/*priya: example to send data to view
		 * sending data to view (jsp page)*/
		/*
		String myName="Priya";	
		String cafeName="Mom's Cafe";
		model.addAttribute("myNameValue",myName);
		model.addAttribute("myCafeName",cafeName);
		*/		
		return "welcome-page";
	}
	
	@RequestMapping("/processOrder")
	public String processOrder(HttpServletRequest request,Model model) {
		
		//set user data using Model data ans send it to concerned view
		String userInput=request.getParameter("foodType"); //same as input name in welcome-page.jsp
		model.addAttribute("userInput",userInput);
		return "process-order";
	}
}
