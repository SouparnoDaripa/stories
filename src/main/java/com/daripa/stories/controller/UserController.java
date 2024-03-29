package com.daripa.stories.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daripa.stories.dao.UserDAO;
import com.daripa.stories.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserDAO userDAO;

	/*
	 * Save the User
	 */
	@PostMapping("/create")
	public User createUser(@Valid @RequestBody User user) {
		return userDAO.save(user);
	}

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
