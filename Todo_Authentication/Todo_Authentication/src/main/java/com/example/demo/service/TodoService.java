package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepo;

@Service
public class TodoService {

	@Autowired
	private TodoRepo todoRepository;

	public Todo addTodo(Todo todo) {

		return todoRepository.save(todo);
	}

	public List<Todo> getAllTodos() {

		return todoRepository.findAll();

	}

	public Todo updateTodo(int todoId, Todo todo) {

		todo.setTodoId(todoId);
		return todoRepository.save(todo);
	}

	public void deleteTodo(int todoId) {

		todoRepository.deleteById(todoId);
	}

}
