package me.ucheng.todo.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import me.ucheng.todo.dao.ToDoDao;
import me.ucheng.todo.domain.ToDo;

public class ToDoDaoImpl extends HibernateDaoSupport implements ToDoDao {

	public void save(ToDo todo) {
		getHibernateTemplate().save(todo);
	}

	public void update(ToDo todo) {
		getHibernateTemplate().update(todo);
	}

	public void delete(ToDo todo) {
		getHibernateTemplate().delete(todo);
	}

	@SuppressWarnings("unchecked")
	public List<ToDo> getAll() {
		List<ToDo> list = getHibernateTemplate().find("from ToDo");
		return list;
	}
	
	public ToDo getById(String id) {
		return (ToDo) getHibernateTemplate().find("from ToDo t where t.id=?", id);
	}

}
