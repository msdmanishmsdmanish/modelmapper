package com.modelmapper.modelmapper.repository;

import com.modelmapper.modelmapper.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
