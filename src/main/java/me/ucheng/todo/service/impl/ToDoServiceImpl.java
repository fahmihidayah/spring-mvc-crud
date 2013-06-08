package me.ucheng.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.ucheng.todo.dao.ToDoDao;
import me.ucheng.todo.domain.ToDo;
import me.ucheng.todo.service.ToDoService;

@Service("toDoService")
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	private ToDoDao toDoDao;
	
	public void save(ToDo todo) {
		toDoDao.save(todo);
	}

	public void update(ToDo todo) {
		toDoDao.save(todo);
	}

	public void delete(ToDo todo) {
		toDoDao.delete(todo);
	}

	public List<ToDo> getAll() {
		return toDoDao.getAll();
	}

	public void delete(int id) {
		ToDo toDo = toDoDao.getById(id);
		if (toDo != null) {
			toDoDao.delete(toDo);
		}
	}

}
