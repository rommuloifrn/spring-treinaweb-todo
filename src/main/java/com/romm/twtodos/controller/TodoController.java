package com.romm.twtodos.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import com.romm.twtodos.entity.Todo;
import com.romm.twtodos.repository.TodoRepository;

@Controller
@RequestMapping("/todos")
public class TodoController {
    
    @Autowired
    TodoRepository todoRepository;

    @GetMapping()
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("todo/list");
        modelAndView.addObject("todos", todoRepository.findAll());
        return modelAndView;
        // return modelAndView("todo/list", Map.of("todos", todoRepository.findAll()));
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("todo/form", Map.of("todo", new Todo()));
    }

    @PostMapping("/create")
    public String create(Todo todo) {
        todoRepository.save(todo);
        return "redirect:/todos";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        Optional<Todo> todo = todoRepository.findById(id);

        if (todo.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        
        return new ModelAndView("todo/form", Map.of("todo", todo.get()));
    }

    @PostMapping("/edit/{id}")
    public String edit(/*@PathVariable Long id, */Todo todo) {
        //todo.setId(id);
        todoRepository.save(todo);

        return "redirect:/todos";
    }
}
