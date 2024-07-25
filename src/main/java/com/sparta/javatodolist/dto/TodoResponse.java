package com.sparta.javatodolist.dto;

import com.sparta.javatodolist.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
public class TodoResponse {
    private Long id;
    private String title;
    private String content;
    private String asignee;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.asignee = todo.getAssignee();
        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
    }
}
