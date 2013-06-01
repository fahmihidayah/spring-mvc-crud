package me.ucheng.todo.domain;

import java.io.Serializable;

public class ToDo implements Serializable{

	private static final long serialVersionUID = -5631376482122232897L;
	
	private Integer id;
	private String description;
	private String status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
