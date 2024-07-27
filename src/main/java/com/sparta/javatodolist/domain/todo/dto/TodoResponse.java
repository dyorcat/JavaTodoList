package com.sparta.javatodolist.domain.todo.dto;

import com.sparta.javatodolist.domain.comment.entity.Comment;
import com.sparta.javatodolist.domain.todo.entity.Todo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class TodoResponse {
    private Long id;
    private String title;
    private String content;
    private String assignee; // 오타 수정
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static TodoResponse toResponse(Todo todo) {
        TodoResponse response = new TodoResponse();
        response.setId(todo.getId());
        response.setTitle(todo.getTitle());
        response.setContent(todo.getContent());
        response.setAssignee(todo.getAssignee());
        response.setCreatedAt(todo.getCreatedAt());
        response.setModifiedAt(todo.getModifiedAt());
        return response;
    }
}
