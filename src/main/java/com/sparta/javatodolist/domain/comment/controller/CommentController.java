package com.sparta.javatodolist.domain.comment.controller;

import com.sparta.javatodolist.domain.comment.dto.CommentResponse;
import com.sparta.javatodolist.domain.comment.dto.CreateCommentRequest;
import com.sparta.javatodolist.domain.comment.dto.UpdateCommentRequest;
import com.sparta.javatodolist.domain.comment.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos/{todoId}/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping()
    public ResponseEntity<CommentResponse> createComment(
            @RequestBody CreateCommentRequest createCommentRequest,
            @PathVariable Long todoId,
            @RequestParam Long userId) {
        CommentResponse response = commentService.createComment(createCommentRequest, todoId, userId);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommentResponse> updateComment(
            @RequestBody UpdateCommentRequest updateCommentRequest,
            @PathVariable Long commentId,
            @PathVariable Long todoId,
            @RequestParam Long userId) {
        CommentResponse response = commentService.updateComment(updateCommentRequest, todoId, commentId, userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(
            @PathVariable Long todoId,
            @PathVariable Long commentId,
            @RequestParam Long userId) {
        commentService.deleteComment(todoId, commentId, userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}