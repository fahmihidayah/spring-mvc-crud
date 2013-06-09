package me.ucheng.todo.controller;

import java.util.List;

import javax.validation.Valid;

import me.ucheng.todo.domain.ToDo;
import me.ucheng.todo.domain.ToDoList;
import me.ucheng.todo.service.ToDoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ToDoController {
	
	@Autowired
	private ToDoService toDoService;
	
	@RequestMapping(value = "/todo", method = RequestMethod.GET)
	public ModelAndView displayTodo() {
		ToDoList toDoList = new ToDoList();
		List<ToDo> toDos = toDoService.getAll();
		toDoList.setTodos(toDos);
		return new ModelAndView("todo", "toDoList", toDoList);
	}

	@ModelAttribute("todoBean")
	public ToDo createToDoBean() {
		System.out.println("create todo bean!");
		return new ToDo();
	}

	@RequestMapping(value = "/todo", method = RequestMethod.POST)
	public String addTodo(@Valid ToDo todo, BindingResult result, SessionStatus sessionStatus) {
		toDoService.save(todo);
		sessionStatus.setComplete();
		return "redirect:/todo";
	}
	
	@RequestMapping(value = "/todo/delete", method = RequestMethod.POST)
	public String deleteToDo(@RequestParam("toDoId") int toDoId) {
		toDoService.delete(toDoId);
		return "redirect:/todo";
	}
	
	@RequestMapping(value = "/todo/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable int id) {
		ToDo toDo = toDoService.getById(id);
		return new ModelAndView("edit", "toDo", toDo);
	}
	
	@RequestMapping(value = "/todo/edit", method = RequestMethod.POST)
	public String update(@RequestParam("id") int id, @RequestParam("description") String description, @RequestParam("status") String status) {
		ToDo toDo = toDoService.getById(id);
		toDo.setDescription(description);
		toDo.setStatus(status);
		toDoService.update(toDo);
		return "redirect:/todo";
	}

}
