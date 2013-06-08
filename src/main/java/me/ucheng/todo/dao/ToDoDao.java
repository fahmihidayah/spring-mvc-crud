package me.ucheng.todo.dao;

import java.util.List;

import me.ucheng.todo.domain.ToDo;

public interface ToDoDao {

	public void save(ToDo todo);
	public void update(ToDo todo);
	public void delete(ToDo todo);
	public List<ToDo> getAll();
	public ToDo getById(int id);
}
