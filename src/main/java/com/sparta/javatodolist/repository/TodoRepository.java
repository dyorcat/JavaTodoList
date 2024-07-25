package com.sparta.javatodolist.repository;

import com.sparta.javatodolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByOrderByCreatedAtDesc();
    List<Todo> findAllByAssignee(String asignee);
    List<Todo> findAllByContentContainsOrderByModifiedAtDesc(String keyword);
}
