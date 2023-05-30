package com.example.todo.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.todo.entity.Todo;

public interface TodoRepository extends CassandraRepository<Todo, Integer> {
}