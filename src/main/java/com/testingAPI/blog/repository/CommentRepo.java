package com.testingAPI.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testingAPI.blog.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
