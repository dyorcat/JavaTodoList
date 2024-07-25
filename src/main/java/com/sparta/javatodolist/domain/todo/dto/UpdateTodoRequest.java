package com.sparta.javatodolist.domain.todo.dto;

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
}


