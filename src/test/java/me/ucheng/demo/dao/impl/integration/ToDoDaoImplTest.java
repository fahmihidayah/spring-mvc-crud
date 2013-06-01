package me.ucheng.demo.dao.impl.integration;

import java.util.List;
import java.util.UUID;

import me.ucheng.todo.dao.ToDoDao;
import me.ucheng.todo.domain.ToDo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ToDoDaoImplTest {
	
	private ToDoDao dao;
	private ApplicationContext appContext ;
	@Before
	public void before() {
		appContext = new ClassPathXmlApplicationContext(new String[] {
		    			  "datasource.xml",
		    			  "hibernate.xml",
		    			  "todo-spring.xml"
		    	  });
		dao = (ToDoDao) appContext.getBean("toDoDao");
	}
	
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
