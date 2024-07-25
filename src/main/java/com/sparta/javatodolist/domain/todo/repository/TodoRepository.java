package com.sparta.javatodolist.domain.todo.repository;

import com.sparta.javatodolist.domain.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByOrderByCreatedAtDesc();
    List<Todo> findAllByAssignee(String assignee);
    List<Todo> findAllByContentContainsOrderByModifiedAtDesc(String keyword);
}
