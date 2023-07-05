package com.testingAPI.blog.services;

import java.util.List;

import com.testingAPI.blog.payload.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user, Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userid);
	
}
