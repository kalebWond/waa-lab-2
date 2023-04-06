package com.example.Lab1.repositories;

import com.example.Lab1.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByAuthor(String author);
}
