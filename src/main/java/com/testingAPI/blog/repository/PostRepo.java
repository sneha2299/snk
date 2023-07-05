package com.testingAPI.blog.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.testingAPI.blog.entity.Category;
import com.testingAPI.blog.entity.Post;
import com.testingAPI.blog.entity.User;
import com.testingAPI.blog.payload.PostDto;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	List<Post> findByTitleContaining(String title);
	}
