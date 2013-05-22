package me.ucheng.demo.dao;

import java.util.List;

import me.ucheng.demo.domain.ToDo;

public interface ToDoDao {

	public void save(ToDo todo);
	public void update(ToDo todo);
	public void delete(ToDo todo);
	public List<ToDo> getAll();
}
