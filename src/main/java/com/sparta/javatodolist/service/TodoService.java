package com.sparta.javatodolist.service;

import com.sparta.javatodolist.dto.CreateTodoRequest;
import com.sparta.javatodolist.dto.TodoResponse;
import com.sparta.javatodolist.entity.Todo;
import com.sparta.javatodolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodoService {
    private final TodoRepository todoRepository;
    @Autowired
    public TodoService(TodoRepository todoRepository) {this.todoRepository = todoRepository; }

    public TodoResponse createTodo(CreateTodoRequest createTodoRequest) {
        Todo todo = createTodoRequest.toEntity();
        Todo savedTodo = todoRepository.save(todo);
        return new TodoResponse(savedTodo);
    }

    public List<TodoResponse> getTodoList() {
        return todoRepository.findAllByOrderByCreatedAtDesc().stream().map(TodoResponse::new).toList();
    }
}
