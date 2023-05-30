package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("todos")
public class Todo {

	@PrimaryKey
	@Id
	private int todoId;

	private String todoName;

	private String task;

	public int getTodoId() {
		return todoId;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public String getTodoName() {
		return todoName;
	}

	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Todo(int todoId, String todoName, String task) {
		super();
		this.todoId = todoId;
		this.todoName = todoName;
		this.task = task;
	}

}
