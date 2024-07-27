package com.sparta.javatodolist.domain.comment.dto;

import com.sparta.javatodolist.domain.comment.entity.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCommentRequest {
    private String content;

}
