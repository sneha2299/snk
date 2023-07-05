package com.testingAPI.blog.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testingAPI.blog.config.AppConstants;
import com.testingAPI.blog.payload.ApiResponse;
import com.testingAPI.blog.payload.PostDto;
import com.testingAPI.blog.payload.PostResponse;
import com.testingAPI.blog.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {

	@Autowired
	private PostService postService;
	//create post
	@PostMapping("/user/{userID}/category/{categoryID}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,@PathVariable Integer userID, @PathVariable Integer categoryID){
		PostDto createdPost = this.postService.createPost(postDto, userID, categoryID);
		return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);		
	}
	
	//get by Category
	@GetMapping("/category/{categoryID}/posts")
	public ResponseEntity<List<PostDto>> getPostBycategory(@PathVariable Integer categoryID){
		List<PostDto> postByCategory = this.postService.getPostByCategory(categoryID);
		return new ResponseEntity<List<PostDto>>(postByCategory, HttpStatus.OK);
	}
	
	//get by user
	@GetMapping("/user/{userID}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userID){
		List<PostDto> postByUser = this.postService.getPostByUser(userID);
		return new ResponseEntity<List<PostDto>>(postByUser, HttpStatus.OK);
	}
	
	//get all posts
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value = "pageNum",defaultValue = AppConstants.PAGE_NUMBER ,required = false) Integer pageNum,
			@RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE,required = false) Integer pageSize,
			@RequestParam(value = "sortBy",defaultValue = AppConstants.SORT_BY,required = false) String sortBy,
			@RequestParam(value = "sortDir",defaultValue = AppConstants.SORT_ORDER,required = false) String sortDir
			){
		PostResponse postResponse = this.postService.getAllPost(pageNum,pageSize,sortBy,sortDir);
		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
	}
	
	//get single post by postID
	@GetMapping("/posts/{postID}")
	public ResponseEntity<PostDto> getSinglePost(@PathVariable Integer postID){
		PostDto singlePost = this.postService.getSinglePost(postID);
		return new ResponseEntity<PostDto>(singlePost, HttpStatus.OK);
	}
	
	//delete post
	@DeleteMapping("/delete/{postID}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postID){
		this.postService.deletePost(postID);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Post deleted successfully...",true), HttpStatus.OK);
	}
	
	// PUT update post
	@PutMapping("/update/{postID}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postID){
		PostDto updatedPost = this.postService.updatePost(postDto, postID);
		return new ResponseEntity<PostDto>(updatedPost,HttpStatus.OK);
		
	}
	
	//seraching post by title
	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPost(@PathVariable String keyword){
		List<PostDto> posts = this.postService.searchPost(keyword);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
		
	}
	
}
