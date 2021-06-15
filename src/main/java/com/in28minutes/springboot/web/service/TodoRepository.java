package com.in28minutes.springboot.web.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.web.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {}