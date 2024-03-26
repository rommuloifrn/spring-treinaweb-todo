package com.romm.twtodos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.romm.twtodos.repository.TodoRepository;

@Controller
public class HomeController {

    @Autowired
    private TodoRepository todoRepository;
    
    //@RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public ModelAndView home() {
        var modelAndView = new ModelAndView("home");
        modelAndView.addObject("nome", "asdasdada asdasdsa");
        var alunos = List.of("roms","may","tutz");
        modelAndView.addObject("alunos", alunos);
        modelAndView.addObject("ehProgramador", false);


        var todos = todoRepository.findAll();
        System.out.println(todos);


        return modelAndView;
    }
}
