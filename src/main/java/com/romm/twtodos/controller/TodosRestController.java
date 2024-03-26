package com.romm.twtodos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romm.twtodos.entity.Todo;
import com.romm.twtodos.repository.TodoRepository;

@RestController
@RequestMapping("/api")
public class TodosRestController {
    @Autowired
    TodoRepository todoRepository;
    
    @GetMapping("/todos")
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }
}
