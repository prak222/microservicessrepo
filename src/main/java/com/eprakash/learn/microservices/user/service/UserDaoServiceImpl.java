package com.eprakash.learn.microservices.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eprakash.learn.microservices.user.domain.User;
import com.eprakash.learn.microservices.user.repository.UserRepository;

@Service("userDaoService")
public class UserDaoServiceImpl implements UserDaoService{

	// find all
private UserRepository userRepo;

public UserDaoServiceImpl (UserRepository userRepo)
{
	this.userRepo=userRepo;
}
	public List<User> findAll() {
		return userRepo.findAll();
	}

	// save
	public User save(User user) {
		userRepo.save(user);
		return user;
	}
	// findbyid

	public Optional<User> getUserById(long id) {
		return userRepo.findById(id);
	}

	public void deleteUserById(long id) {

		 userRepo.deleteById(id);

	}
}
