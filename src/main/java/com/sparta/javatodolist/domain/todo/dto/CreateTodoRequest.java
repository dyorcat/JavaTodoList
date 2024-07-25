package com.sparta.javatodolist.domain.todo.dto;

import com.sparta.javatodolist.domain.todo.entity.Todo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateTodoRequest {

    @NotBlank(message = "할 일 제목은 필수 입력값입니다.")
    @Size(max = 200, message = "할일 제목은 최대 200자 이내로 입력해야 합니다.")
    private String title;

    @NotBlank(message = "내용은 필수 입력값입니다.")
    private String content;

    @NotBlank(message = "담당자는 필수 입력값입니다.")
    @Email(message = "담당자는 유효한 이메일 주소 형식으로 입력해야 합니다. ")
    private String assignee;

    @NotBlank(message = "비밀번호는 필수 입력값입니다. ")
    private String password;

    public Todo toEntity() {
        Todo todo = new Todo();
        todo.setTitle(this.title);
        todo.setContent(this.content);
        todo.setAssignee(this.assignee);
        todo.setPassword(this.password);
        return todo;
    }

}
