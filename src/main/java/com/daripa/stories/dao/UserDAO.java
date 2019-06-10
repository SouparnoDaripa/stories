package com.daripa.stories.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	 * search all users from the table
	 */
	public List<User> findAll() {
		return userRepository.findAll();
	}

	/*
	 * Search a User in table by User Id
	 */
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	/*
	 * Update a User from table
	 */
	public User update(User user) {
		return this.save(user);
	}
}