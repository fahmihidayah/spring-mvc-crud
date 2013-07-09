package me.ucheng.todo.utils;

import java.util.Comparator;

import me.ucheng.todo.domain.ToDo;

public class ToDoPriorityComparator implements Comparator<ToDo> {

	public int compare(ToDo o1, ToDo o2) {
		return o1.getPriority() - o2.getPriority();
	}

}
