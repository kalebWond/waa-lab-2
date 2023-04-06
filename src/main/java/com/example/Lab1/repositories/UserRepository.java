package com.example.Lab1.repositories;

import com.example.Lab1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE size(u.posts) > 1")
    List<User> getUsersWithMultiplePosts();
}
