package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.entity.User;
import com.org.repository.UserRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Service
public class UserServiceImpl implements UserService {


	    private final UserRepository userRepository;
	    private final PasswordEncoder passwordEncoder;

	    @Autowired
	    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
	        this.userRepository = userRepository;
	        this.passwordEncoder = passwordEncoder;
	    }

	    @Transactional
	    @Override
	    public User createUser(@Valid User user, @NotBlank String rawPassword) {
	        user.setPassword(passwordEncoder.encode(rawPassword));
	        return userRepository.save(user);
	    }

	    @Transactional(readOnly = true)
	    @Override
	    public User getUserByUsername(String username) {
	        return userRepository.findByUsername(username);
	    }


	

	
}
