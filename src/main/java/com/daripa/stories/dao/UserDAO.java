package com.daripa.stories.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daripa.stories.exception.ResourceNotFoundException;
import com.daripa.stories.model.User;
import com.daripa.stories.repository.UserRepository;

/**
 * A DAO for the entity User is simply created by extending the CrudRepository
 * interface provided by spring. The following methods are some of the ones
 * available from such interface: save, delete, deleteAll, findOne and findAll.
 * The magic is that such methods must not be implemented, and moreover it is
 * possible create new query methods working only by defining their signature!
 * 
 * @author souparnod
 */

@Service
public class UserDAO {

	@Autowired
	UserRepository userRepository;

	/*
	 * Save a User in table
	 */
	public User save(User user) {
		return userRepository.save(user);
	}

	/*
	 * Update a User from table
	 */
	public User update(User user) {
		return this.save(user);
	}

	/*
	 * search all users from the table
	 */
	public List<User> findAll() {
		return userRepository.findAll();
	}

	/*
	 * Search a User in table by User Id
	 */
	public User findById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User with userId " + id + "doesnot exist"));
	}

	/*
	 * Search a User in table by Email Address
	 */
	public User findByEmail(String email) {
		return userRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("User with email address " + email + "doesnot exist"));
	}

	/*
	 * Search a User in table by Username or Email Address
	 */
	public User findByUsernameOrEmail(String username, String email) {
		return userRepository.findByUsernameOrEmail(username, email).orElseThrow(() -> new ResourceNotFoundException(
				"User with username " + username + " or email address " + email + "doesnot exist"));
	}

	/*
	 * Search a User in table by Username
	 */
	public User findByUsername(String username) {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("User with username " + username + "doesnot exist"));
	}

	/*
	 * Search the list of users in table by ids
	 */
	public List<User> findByIds(List<Long> userIds) {
		return userRepository.findByIdIn(userIds);
	}

	/*
	 * Check whether User exists with username
	 */
	public Boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	/*
	 * Check whether User exists with email address
	 */
	public Boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

}