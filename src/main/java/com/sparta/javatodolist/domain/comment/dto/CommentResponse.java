package com.sparta.javatodolist.domain.comment.dto;

import com.sparta.javatodolist.domain.comment.entity.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentResponse {
    private Long id;
    private String content;
    private Long userId;
    private Long todoId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.userId = comment.getUserId();
        this.todoId = comment.getTodoId();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}