package com.in28minutes.springboot.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.springboot.web.model.Todo;

@Service
public class TodoService {
	
	@Autowired
	TodoRepository repository;

    public List<Todo> retrieveTodos() {
        return repository.findAll();
    }
    
    public Todo retrieveTodo(int id) {
        return repository.findById(id).get();
    }

    public void updateTodo(Todo todo){
    	repository.delete(todo);
    	repository.save(todo);
    }

    public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
        repository.save(new Todo(name, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        repository.deleteById(id);
    }
}