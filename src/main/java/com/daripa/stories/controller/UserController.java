package com.daripa.stories.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daripa.stories.dao.UserDAO;
import com.daripa.stories.model.User;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserDAO userDAO;

	/*
	 * Get List of Users
	 */
	@GetMapping("/query")
	public List<User> getAllUsers() {
		return userDAO.findAll();
	}

	/*
	 * Get the user with user id
	 */
	@GetMapping("/detail/{id}")
	public User getUserById(@PathVariable(value = "id") Long id) {
		return userDAO.findById(id);
	}
}
