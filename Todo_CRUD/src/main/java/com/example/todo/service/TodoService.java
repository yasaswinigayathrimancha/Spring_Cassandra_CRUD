package com.example.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.entity.Todo;
import com.example.todo.repo.TodoRepository;

@Service
public class TodoService {
	private final TodoRepository todoRepository;

	@Autowired
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public List<Todo> getAllTodos() {
		return (List<Todo>) todoRepository.findAll();
	}

	public Optional<Todo> getTodoById(int id) {
		return todoRepository.findById(id);
	}

	public Todo createTodo(Todo todo) {
// Auto-generate the primary key
		int generatedId = todoRepository.findAll().size() + 1;
		todo.setId(generatedId);
		return todoRepository.save(todo);
	}

	public Todo updateTodo(Todo todo) {
		return todoRepository.save(todo);
	}

	public void deleteTodoById(int id) {
		todoRepository.deleteById(id);
	}
}