package com.example.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;

@RestController
@RequestMapping("/todos/")
public class TodoController {
	private final TodoService todoService;

	@Autowired
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping("getall/")
	public ResponseEntity<List<Todo>> getAllTodos() {
		List<Todo> todos = todoService.getAllTodos();
		return new ResponseEntity<>(todos, HttpStatus.OK);
	}

	@GetMapping("getbyid/{id}/")
	public ResponseEntity<Todo> getTodoById(@PathVariable("id") int id) {
		Optional<Todo> todo = todoService.getTodoById(id);
		if (todo.isPresent()) {
			return new ResponseEntity<>(todo.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("add/")
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
		try {
			Todo createdTodo = todoService.createTodo(todo);
			return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("update/{id}/")
	public ResponseEntity<Todo> updateTodo(@PathVariable("id") int id, @RequestBody Todo todo) {
		Optional<Todo> existingTodo = todoService.getTodoById(id);
		if (existingTodo.isPresent()) {
			todo.setId(id);
			Todo updatedTodo = todoService.updateTodo(todo);
			return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("delete/{id}/")
	public ResponseEntity<HttpStatus> deleteTodo(@PathVariable("id") int id) {
		Optional<Todo> todo = todoService.getTodoById(id);
		if (todo.isPresent()) {
			todoService.deleteTodoById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}