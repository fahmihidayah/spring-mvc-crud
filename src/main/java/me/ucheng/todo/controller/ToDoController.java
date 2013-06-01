package me.ucheng.todo.controller;

import javax.validation.Valid;

import me.ucheng.todo.domain.ToDo;
import me.ucheng.todo.service.ToDoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ToDoController {
	
	@Autowired
	private ToDoService toDoService;
	
	@RequestMapping(value = "/todo", method = RequestMethod.GET)
	public String displayTodo() {
		return "/todo";
	}

	@ModelAttribute("todoBean")
	public ToDo createToDoBean() {
		System.out.println("create todo bean!");
		return new ToDo();
	}

	@RequestMapping(value = "/todo", method = RequestMethod.POST)
	public ModelAndView addTodo(@Valid ToDo todo, BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("todo");
		}
		
		toDoService.save(todo);

		return new ModelAndView("todo");
	}

}
