package com.sparta.javatodolist.controller;

import com.sparta.javatodolist.dto.CreateTodoRequest;
import com.sparta.javatodolist.dto.TodoResponse;
import com.sparta.javatodolist.dto.UpdateTodoRequest;
import com.sparta.javatodolist.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/{id}")
    public TodoResponse getTodo(@PathVariable Long id) {
        return todoService.getTodo(id);
    }

    @PutMapping("/{id}")
    public TodoResponse updateTodo(@PathVariable Long id, @RequestBody UpdateTodoRequest updateTodoRequest) {
        return todoService.updateTodo(id, updateTodoRequest);
    }


}
