package com.testingAPI.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testingAPI.blog.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
}
