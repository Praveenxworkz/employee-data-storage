package com.org.service;

import com.org.entity.User;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public interface UserService {
	
	User createUser(@Valid User user, @NotBlank String rawPassword);
    User getUserByUsername(String username);
	
}
