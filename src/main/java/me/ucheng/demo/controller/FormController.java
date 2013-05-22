package me.ucheng.demo.controller;

import javax.validation.Valid;

import me.ucheng.demo.domain.FormBean;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes("formBean")
public class FormController {
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String displayForm() {
		return "/form";
	}

	@ModelAttribute("formBean")
	public FormBean createFormBean() {
		System.out.println("create form bean!");
		return new FormBean();
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public ModelAndView submitMessage(@Valid FormBean formBean, BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("form");
		}
		String message = formBean.toString();
		System.out.println("message:" + message);

		return new ModelAndView("form", "message", formBean.getMessageFromUser());
	}

}
