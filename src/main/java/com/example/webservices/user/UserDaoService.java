package com.example.webservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {

	private static List<User> users = new ArrayList();
	private static int userCount = 3;

	static {
		users.add(new User(1, "Shehbaz Ansari", new Date()));
		users.add(new User(2, "Saad Ansari", new Date()));
		users.add(new User(3, "Saba Ansari", new Date()));
	}

	// Get All Users
	public List<User> findAll() {
		return users;
	}

	// Add User
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	// Get Only One Users
	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;

	}
}