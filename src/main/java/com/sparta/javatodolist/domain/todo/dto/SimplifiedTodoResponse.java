package com.sparta.javatodolist.domain.todo.dto;

import com.sparta.javatodolist.domain.todo.entity.Todo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SimplifiedTodoResponse {
        private Long id;
        private String title;

        public static SimplifiedTodoResponse fromEntity(Todo todo) {
                SimplifiedTodoResponse response = new SimplifiedTodoResponse();
                response.setId(todo.getId());
                response.setTitle(todo.getTitle());
                return response;
        }
}