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
    private String asignee;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private List<Comment> commentList;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.asignee = todo.getAssignee();
        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
        this.commentList = todo.getCommentList();
    }
}
