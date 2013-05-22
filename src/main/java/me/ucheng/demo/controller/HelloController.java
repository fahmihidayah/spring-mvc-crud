package me.ucheng.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public ModelAndView hello() {
		return new ModelAndView("hello", "message", "Hello World Spring 2.0 MVC!");
		
	}
}
