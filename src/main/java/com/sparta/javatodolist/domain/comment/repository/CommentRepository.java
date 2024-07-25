package com.sparta.javatodolist.domain.comment.repository;

import com.sparta.javatodolist.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
