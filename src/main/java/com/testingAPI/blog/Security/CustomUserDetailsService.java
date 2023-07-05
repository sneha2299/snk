package com.testingAPI.blog.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.testingAPI.blog.entity.User;
import com.testingAPI.blog.exception.ResourceNotFoundException;
import com.testingAPI.blog.repository.UserRepo;

public class CustomUserDetailsService  implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//loading user from database by username
		User user = this.userRepo.findByemail(username).orElseThrow(() -> new ResourceNotFoundException("User", "email: "+username, 0));
		
		return user;
	}

}
