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

    public static CommentResponse toResponse(Comment comment) {
        CommentResponse response = new CommentResponse();
        response.setId(comment.getId());
        response.setContent(comment.getContent());
        response.setUserId(comment.getUserId());
        response.setTodoId(comment.getTodoId());
        response.setCreatedAt(comment.getCreatedAt());
        response.setModifiedAt(comment.getModifiedAt());
        return response;
    }
}