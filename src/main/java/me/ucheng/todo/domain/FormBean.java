package me.ucheng.todo.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class FormBean {

	@NotEmpty
	private String messageFromUser;

	public String getMessageFromUser() {
		return messageFromUser;
	}

	public void setMessageFromUser(String messageFromUser) {
		this.messageFromUser = messageFromUser;
	}

	@Override
	public String toString() {
		return "FormBean [messageFromUser=" + messageFromUser + "]";
	}
}
