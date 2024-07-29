package com.sparta.javatodolist.domain.todo.service;

import com.sparta.javatodolist.domain.todo.dto.CreateTodoRequest;
import com.sparta.javatodolist.domain.todo.dto.SimplifiedTodoResponse;
import com.sparta.javatodolist.domain.todo.dto.TodoResponse;
import com.sparta.javatodolist.domain.todo.dto.UpdateTodoRequest;
import com.sparta.javatodolist.domain.todo.entity.Todo;
import com.sparta.javatodolist.domain.todo.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Component
public class TodoService {
    private static final Logger logger = LoggerFactory.getLogger(TodoService.class);
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponse createTodo(CreateTodoRequest createTodoRequest) {
        Todo todo = new Todo();
        todo.setTitle(createTodoRequest.getTitle());
        todo.setContent(createTodoRequest.getContent());
        todo.setAssignee(createTodoRequest.getAssignee());
        todo.setPassword(createTodoRequest.getPassword());
        Todo savedTodo = todoRepository.save(todo);
        return TodoResponse.toResponse(savedTodo);
    }

    public TodoResponse getTodoById(Long id) {
        Todo foundTodo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당하는 할 일이 없습니다. "));
        return TodoResponse.toResponse(foundTodo);
    }

    public List<SimplifiedTodoResponse> getTodoList() {
        return todoRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(SimplifiedTodoResponse::fromEntity)
                .toList();
    }


    public TodoResponse updateTodo(Long id, UpdateTodoRequest updateTodoRequest) {
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당하는 할 일이 없습니다."));

        // 비밀번호 검증
        if (!existingTodo.getPassword().equals(updateTodoRequest.getPassword())) {
            logger.warn("비밀번호 검증 실패: 요청된 ID: {}, 제공된 비밀번호: {}, 저장된 비밀번호: {}",
                    id, updateTodoRequest.getPassword(), existingTodo.getPassword());
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }
        existingTodo.setTitle(updateTodoRequest.getTitle());
        existingTodo.setContent(updateTodoRequest.getContent());
        existingTodo.setAssignee(updateTodoRequest.getAssignee());

        // 수정된 엔티티 저장
        Todo updatedTodo = todoRepository.save(existingTodo);
        return TodoResponse.toResponse(updatedTodo);
    }

    public void deleteTodo(Long id, String password) {
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당하는 할 일이 없습니다."));
        if (!existingTodo.getPassword().equals(password)) {
            logger.warn("비밀번호 검증 실패: 요청된 ID: {}, 제공된 비밀번호: {}, 저장된 비밀번호: {}",
                    id, password, existingTodo.getPassword());
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }
        todoRepository.delete(existingTodo);
    }
}

