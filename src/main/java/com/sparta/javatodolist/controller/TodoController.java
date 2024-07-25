package com.sparta.javatodolist.controller;

import com.sparta.javatodolist.dto.CreateTodoRequest;
import com.sparta.javatodolist.dto.TodoResponse;
import com.sparta.javatodolist.service.TodoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todos")
    public TodoResponse createTodo(@RequestBody CreateTodoRequest createTodoRequest) {
        return todoService.createTodo(createTodoRequest);
    }


}
