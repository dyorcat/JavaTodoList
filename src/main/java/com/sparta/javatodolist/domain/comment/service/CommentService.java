package com.sparta.javatodolist.domain.comment.service;

import com.sparta.javatodolist.domain.comment.dto.CommentResponse;
import com.sparta.javatodolist.domain.comment.dto.CreateCommentRequest;
import com.sparta.javatodolist.domain.comment.dto.UpdateCommentRequest;
import com.sparta.javatodolist.domain.comment.entity.Comment;
import com.sparta.javatodolist.domain.comment.repository.CommentRepository;
import com.sparta.javatodolist.domain.todo.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;


@Slf4j
@Component
public class CommentService {
    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, TodoRepository todoRepository) {
        this.commentRepository = commentRepository;
        this.todoRepository = todoRepository;
    }

    public CommentResponse createComment(CreateCommentRequest createCommentRequest, Long todoId, Long userId) {
        if (!todoRepository.existsById(todoId)) {
            log.error("일정이 존재하지 않습니다. ID: {}", todoId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "선택한 일정이 존재 하지 않습니다.");
        }
        if (createCommentRequest.getContent().isBlank()) {
            log.error("댓글 내용이 비어 있습니다.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "댓글 내용은 필수 입력 값입니다.");
        }
        Comment comment = createCommentRequest.toEntity(todoId, userId);
        Comment savedComment = commentRepository.save(comment);
        return new CommentResponse(savedComment);
    }


    public CommentResponse updateComment(UpdateCommentRequest updateCommentRequest, Long todoId, Long commentId, Long userId) {
        if (!todoRepository.existsById(todoId)) {
            log.error("일정이 존재하지 않습니다. ID: {}", todoId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "선택한 일정이 존재하지 않습니다.");
        }
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> {
                    log.error("댓글이 존재하지 않습니다. ID: {}", commentId);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "선택한 댓글이 존재하지 않습니다. ");
                });
        if (!comment.getUserId().equals(userId)) {
            log.error("댓글 작성자가 일치하지 않습니다. 요청된 사용자 ID: {}, 댓글 작성자 ID: {}",
                    userId, comment.getUserId());
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "댓글 작성자가 일치하지 않습니다.");
        }

        comment.setContent((updateCommentRequest.getContent()));
        Comment updatedComment = commentRepository.save(comment);
        return new CommentResponse(updatedComment);
    }

    public void deleteComment(Long todoId, Long commentId, Long userId) {
        if (!todoRepository.existsById(todoId)) {
            log.error("일정이 존재하지 않습니다. ID: {}", todoId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "선택한 일정이 존재하지 않습니다.");
        }

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> {
                    log.error("댓글이 존재하지 않습니다. ID: {}", commentId);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "선택한 댓글이 존재하지 않습니다.");
                });

        if (!comment.getUserId().equals(userId)) {
            log.error("댓글 작성자가 일치하지 않습니다. 요청된 사용자 ID: {}, 댓글 작성자 ID: {}",
                    userId, comment.getUserId());
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "댓글 작성자가 일치하지 않습니다.");
        }

        commentRepository.delete(comment);
    }
}
