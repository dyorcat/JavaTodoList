package com.sparta.javatodolist.controller;

import com.sparta.javatodolist.dto.CreateTodoRequest;
import com.sparta.javatodolist.dto.TodoResponse;
import com.sparta.javatodolist.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping()
    public TodoResponse createTodo(@RequestBody CreateTodoRequest createTodoRequest) {
        return todoService.createTodo(createTodoRequest);
    }

    @GetMapping()
    public List<TodoResponse> getTodoList() {
        return todoService.getTodoList();
    }


}
