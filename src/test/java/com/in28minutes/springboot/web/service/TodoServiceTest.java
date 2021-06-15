package com.in28minutes.springboot.web.service;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.springboot.web.model.Todo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoServiceTest {
	
	@Autowired
	TodoService service;
	
	@MockBean
	TodoRepository repositoryMock;
	
	List<Todo> todos;
	Todo todo1 = new Todo(0, "ahmed", "Learn Spring MVC", new Date(), false);
	Todo todo2 = new Todo(1, "ahmed", "Learn Struts", new Date(), false);
	Todo todo3 = new Todo(2, "ahmed", "Learn Hibernate", new Date(), false);		
	
	@Before
	public void beforeEach() {
		todos = new ArrayList<Todo>();
		todos.add(todo1);
		todos.add(todo2);
		todos.add(todo3);
	}
	
	@Test
	public void retrieveTodosTest() {
		// arrange
		Mockito.when(repositoryMock.findAll()).thenReturn(todos);
		// act
		List<Todo> result = service.retrieveTodos();
		// assert
		assertSame(todos, result);
	}
	
	@Test
	public void retrieveTodoTets() {
		// arrange
		Mockito.when(repositoryMock.findById(Mockito.anyInt())).thenReturn(Optional.of(todo1));
		// act
		Todo todo = service.retrieveTodo(0);
		// assert
		assertSame(todo, todo1);
	}
	
	@Test
	public void updateTodoTest() {
		// arrange
		Todo todo = new Todo(0, "sobh", "Learn Spring MVC", new Date(), true);
		Mockito.when(repositoryMock.findById(Mockito.anyInt())).thenReturn(Optional.of(todo));
		// act
		service.updateTodo(todo);
		// assert
		Todo updatedTodo = service.retrieveTodo(0);
		assertSame(todo, updatedTodo);
	}
}
