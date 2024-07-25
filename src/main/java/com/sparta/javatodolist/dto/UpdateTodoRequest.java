package com.sparta.javatodolist.dto;

import com.sparta.javatodolist.entity.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateTodoRequest {
    private String title;
    private String content;
    private String assignee;
    private String password;


    public Todo toEntity(Todo existingTodo) {
        existingTodo.setTitle(this.title);
        existingTodo.setContent(this.content);
        existingTodo.setAssignee(this.assignee);
        return existingTodo;
    }
}


