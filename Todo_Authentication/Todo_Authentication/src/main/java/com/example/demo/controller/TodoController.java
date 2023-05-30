package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {

		Todo newTodo = todoService.addTodo(todo);

		return new ResponseEntity<Todo>(newTodo, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@PreAuthorize("hasRole('user')")
	public ResponseEntity<?> getAllTodos() {

		List<Todo> todolist = todoService.getAllTodos();

		return ResponseEntity.status(HttpStatus.OK).body(todolist);
	}

	@RequestMapping(value = "/update/{todoId}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<?> updateTodo(@PathVariable(name = "todoId") int todoId, @RequestBody Todo todo) {
		Todo todoToUpdate = todoService.updateTodo(todoId, todo);

		return ResponseEntity.status(HttpStatus.OK).body(todoToUpdate);
	}

	@RequestMapping(value = "/delete/{todoId}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<?> deleteTodo(@PathVariable(name = "todoId") int todoId) {

		todoService.deleteTodo(todoId);
		return ResponseEntity.status(HttpStatus.OK).body("Todo removed..");
	}
}
