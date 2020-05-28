package com.luxoft.jva010.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

@Controller
public class HelloController {

	@RequestMapping(value ="/greeting")
	public String sayHello (Model model)
	{
		model.addAttribute("greeting", "Hello my friend!");
		
		return "hello-page";
	}

	@RequestMapping(value = "/processAge")
	public String getTestData(String test, @RequestParam("age")  Integer age, HttpSession session, WebRequest request)
	{
		System.out.println("->>> " + test + " " + age);

		session.setAttribute("isAgeProcessed", true);

		return "hello-page";
	}

}
