package com.testingAPI.blog.payload;

import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 4, message = "username must be min of 4 characters")
	private String name;
	
	@Email(message = "Email address is not valid")
	private String email;
	
	@NotEmpty
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{3,10}$",
            message = "password must be min 3 and max 10 length containing atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
	private String password;
	
	@NotEmpty
	private String about;
	
	private Set<CommentDto> comments = new HashSet<>();


}
