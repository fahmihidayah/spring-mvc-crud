package me.ucheng.demo.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import me.ucheng.demo.dao.ToDoDao;
import me.ucheng.demo.domain.ToDo;

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

	public List<ToDo> getAll() {
		List<ToDo> list = (List<ToDo>)getHibernateTemplate().find("from list");
		return list;
	}

}
