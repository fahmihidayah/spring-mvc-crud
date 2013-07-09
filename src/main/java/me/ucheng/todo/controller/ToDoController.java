package me.ucheng.todo.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;

import me.ucheng.todo.domain.ToDo;
import me.ucheng.todo.domain.ToDoList;
import me.ucheng.todo.service.ToDoService;
import me.ucheng.todo.utils.ToDoPriorityComparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

@Controller
public class ToDoController {
	
	@Autowired
	private ToDoService toDoService;
	
	@RequestMapping(value = "/todo", method = RequestMethod.GET)
	public ModelAndView displayTodo() {
		ToDoList toDoList = new ToDoList();
		List<ToDo> toDos = toDoService.getAll();
		Collections.sort(toDos, new ToDoPriorityComparator());
		toDoList.setTodos(toDos);
		return new ModelAndView("todo", "toDoList", toDoList);
	}

	@ModelAttribute("todoBean")
	public ToDo createToDoBean() {
		return new ToDo();
	}

	@RequestMapping(value = "/todo", method = RequestMethod.POST)
	public String addTodo(@Valid ToDo todo, BindingResult result, SessionStatus sessionStatus) {
		List<ToDo> toDos = toDoService.getAll();
		if (toDos.size() > 0) {
			Collections.sort(toDos, new ToDoPriorityComparator());
			ToDo last = toDos.get(toDos.size() - 1);
			todo.setPriority(last.getPriority() + 1);
		} else {
			todo.setPriority(0);
		}
		toDoService.save(todo);
		sessionStatus.setComplete();
		return "redirect:/todo";
	}
	
	@RequestMapping(value = "/todo/delete/{id}", method = RequestMethod.GET)
	public String deleteToDo(@PathVariable int id) {
		toDoService.delete(id);
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
	
	@RequestMapping(value = "/todo/done/{id}", method = RequestMethod.GET)
	public String done(@PathVariable int id) {
		ToDo toDo = toDoService.getById(id);
		toDo.setStatus("done");
		toDoService.update(toDo);
		return "redirect:/todo";
	}
	
	@RequestMapping(value = "/todo/updateOrder", method = RequestMethod.POST, headers ={"Accept=application/json"})
	@ResponseBody
	public String updateOrder(@RequestBody String updateEntries) throws JsonProcessingException, IOException, InterruptedException {
		String json = StringUtils.replace(updateEntries, "\\", "");
		System.out.println("===>todos:" + json);
		ObjectMapper mapper = new ObjectMapper();
        ObjectReader reader = mapper.reader();
        JsonNode node = reader.readTree(json);
        JsonNode itemOrder = node.get("updateEntries");
        int size = itemOrder.size();
        for (int i = 0; i < size; i++) {
        	int order = itemOrder.get(i).asInt();
        	ToDo todo = toDoService.getById(order);
        	todo.setPriority(i);
        	toDoService.update(todo);
        }
		return "{\"hi\":\"yes\"}";
	}

}
