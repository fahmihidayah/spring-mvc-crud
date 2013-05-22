package me.ucheng.demo.service;

import me.ucheng.demo.dao.ToDoDao;
import me.ucheng.demo.domain.ToDo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext appContext = 
		    	  new ClassPathXmlApplicationContext(new String[] {
		    			  "datasource.xml",
		    			  "hibernate.xml",
		    			  "todo-spring.xml"
		    	  });
		
		ToDoDao dao = (ToDoDao) appContext.getBean("toDoDao");
		ToDo todo = new ToDo();
		todo.setId(1);
		todo.setDescription("learn spring");
		todo.setStatus("undone");
		
		dao.save(todo);
		 
	}
}
