package com.sparta.javatodolist.dto;

import com.sparta.javatodolist.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateTodoRequest {
    private String title;
    private String content;
    private String assignee;
    private String password;


    public CreateTodoRequest(String title, String content, String assignee, String password) {
        this.title = title;
        this.content = content;
        this.assignee = assignee;
        this.password = password;
    }

    public Todo toEntity() {
        Todo todo = new Todo();
        todo.setTitle(this.title);
        todo.setContent(this.content);
        todo.setAssignee(this.assignee);
        todo.setPassword(this.password);
        return todo;
    }

}
