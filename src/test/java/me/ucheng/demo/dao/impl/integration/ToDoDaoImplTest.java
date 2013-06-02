package me.ucheng.demo.dao.impl.integration;

import java.util.List;
import java.util.UUID;

import me.ucheng.todo.dao.ToDoDao;
import me.ucheng.todo.domain.ToDo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * To run this test you need to start MySQL server first
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/todo-spring.xml")
public class ToDoDaoImplTest {
	
	@Autowired
	@Qualifier("toDoDao")
	private ToDoDao dao;

	@Test
	public void shouldSaveToDo() {
		ToDo todo = new ToDo();
		todo.setDescription("read book-" + UUID.randomUUID());
		todo.setStatus("undo");
		dao.save(todo);
	}
	
	@Test
	public void shouldGetToDolist() {
		List<ToDo> todos = dao.getAll();
		for (ToDo todo: todos) {
			System.out.println("ToDo desc: " + todo.getDescription());
			System.out.println("ToDo status: " + todo.getStatus());
		}
	}
	
	@Test
	public void shouldUpdateTodo() {
		List<ToDo> todos = dao.getAll();
		for (ToDo tado: todos) {
			tado.setStatus("done");
			dao.update(tado);
		}
	}
	
	@Test
	public void shouldDeleteToDo() {
		List<ToDo> todos = dao.getAll();
		for (ToDo tado: todos) {
			dao.delete(tado);
		}
	}
}
