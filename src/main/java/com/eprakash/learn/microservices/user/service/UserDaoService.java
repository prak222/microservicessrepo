package com.eprakash.learn.microservices.user.service;

import java.util.List;
import java.util.Optional;

import com.eprakash.learn.microservices.user.domain.User;

public interface UserDaoService {


	// find all
	public List<User> findAll();
	// save
	public User save(User user);
	// findbyid

	public Optional<User> getUserById(long id);

	public void deleteUserById(long id);
	
}
