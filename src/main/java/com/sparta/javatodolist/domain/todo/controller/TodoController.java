package com.sparta.javatodolist.domain.todo.controller;

import com.sparta.javatodolist.domain.todo.dto.CreateTodoRequest;
import com.sparta.javatodolist.domain.todo.dto.SimplifiedTodoResponse;
import com.sparta.javatodolist.domain.todo.dto.TodoResponse;
import com.sparta.javatodolist.domain.todo.dto.UpdateTodoRequest;
import com.sparta.javatodolist.domain.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TodoResponse> createTodo(@Valid @RequestBody CreateTodoRequest createTodoRequest) {
        TodoResponse response = todoService.createTodo(createTodoRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> getTodo(@PathVariable Long id) {
        TodoResponse response = todoService.getTodoById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<SimplifiedTodoResponse>> getTodoList() {
        List<SimplifiedTodoResponse> response = todoService.getTodoList();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TodoResponse> updateTodo(
            @PathVariable Long id,
            @RequestBody UpdateTodoRequest updateTodoRequest) {
        TodoResponse response = todoService.updateTodo(id, updateTodoRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id, @RequestParam String password) {
        todoService.deleteTodo(id, password);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
