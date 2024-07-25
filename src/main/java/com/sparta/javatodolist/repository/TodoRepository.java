package com.sparta.javatodolist.repository;

import com.sparta.javatodolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByOrderByCreatedAtDesc();

    Optional<Todo> findById(Long id);
    List<Todo> findAllByAssignee(String assignee);
    List<Todo> findAllByContentContainsOrderByModifiedAtDesc(String keyword);
}
