package com.romm.twtodos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.romm.twtodos.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
