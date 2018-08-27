package com.eprakash.learn.microservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1, "prakash", new Date()));
		users.add(new User(2, "sandhya", new Date()));
		users.add(new User(3, "hitika", new Date()));
	}

	// find all

	public List<User> findAll() {
		return users;
	}

	// save
	public User save(User user) {
		if (user != null) {
			if (user.getId() == null) {
				user.setId(users.size() + 1);
			}
			users.add(user);
		}
		return user;
	}
	// findbyid

	public User getUserById(int id) {

		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;

	}

	public User deleteUserById(int id) {

		User user = getUserById(id);
		if (user != null) {
			users.remove(user);
			return user;
		}
		return null;

	}
}
