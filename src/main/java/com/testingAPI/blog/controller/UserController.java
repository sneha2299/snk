package com.testingAPI.blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testingAPI.blog.payload.ApiResponse;
import com.testingAPI.blog.payload.UserDto;
import com.testingAPI.blog.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	//POST
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		
		UserDto createUserDto= this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
		
	}
	
	//PUT - update
	@PutMapping("/{userID}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userID ){
		UserDto updatedUserDto = this.userService.updateUser(userDto, userID);
		return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
		
	}
	
	
	//DELETE 
	@DeleteMapping("/{userID}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userID){
		this.userService.deleteUser(userID);
		return new ResponseEntity<>(new ApiResponse("user Deleted successfully", true),HttpStatus.OK);
		
	}
	
	
	//GET all users
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
		
	}
	
	//GET single user
	@GetMapping("/{userID}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userID){
		return ResponseEntity.ok(this.userService.getUserById(userID));
		
	}
	
}
