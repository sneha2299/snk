package com.testingAPI.blog.services;

import org.springframework.stereotype.Service;

import com.testingAPI.blog.payload.CommentDto;

@Service
public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto, Integer postID, Integer userID);
	
	void deleteComment(Integer commentID);
	
}
