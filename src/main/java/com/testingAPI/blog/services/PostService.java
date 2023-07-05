package com.testingAPI.blog.services;

import java.util.List;

import com.testingAPI.blog.entity.Post;
import com.testingAPI.blog.payload.PostDto;
import com.testingAPI.blog.payload.PostResponse;

public interface PostService {

	//create
	PostDto createPost(PostDto postDto,Integer userID,Integer categoryID);
	
	//update
	PostDto updatePost(PostDto postDto, Integer postID);
	
	//delete
	
	void deletePost(Integer postID);
	
	//get ALL
	PostResponse getAllPost(Integer pageNum, Integer PageSize,String sortBy, String sortDir);
	
	//get single post
	PostDto getSinglePost(Integer postID);
	
	//get all post by category
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//get all posts by user
	List<PostDto> getPostByUser(Integer userID);
	
	//search post
	List<PostDto> searchPost(String keyword);
	
}
