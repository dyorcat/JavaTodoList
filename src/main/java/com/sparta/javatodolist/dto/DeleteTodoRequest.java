package com.sparta.javatodolist.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteTodoRequest {
    private String password;

    public DeleteTodoRequest(String password) {
        this.password = password;
    }
}
