package com.modelmapper.modelmapper.repository;

import com.modelmapper.modelmapper.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
