package com.daripa.stories.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daripa.stories.exception.ResourceNotFoundException;
import com.daripa.stories.model.Story;
import com.daripa.stories.model.User;
import com.daripa.stories.repository.StoryRepository;
import com.daripa.stories.repository.UserRepository;

@Service
public class StoryDAO {

	@Autowired
	UserRepository userRepository;
	@Autowired
	StoryRepository storyRepository;

	/*
	 * Save a Story in table
	 */
	public Story save(Story story, Long id) {
		Optional<User> author = userRepository.findById(id);
		if (author.isPresent()) {
			story.setAuthor((User) author.get());
			return storyRepository.save(story);
		} else {
			throw new ResourceNotFoundException("User with User Id " + id + " not found");
		}
	}

	/*
	 * Fetches all stories from table
	 */
	public List<Story> findAll() {
		return storyRepository.findAll();
	}

	/*
	 * Fetch a Story by storyId from table
	 */
	public Optional<Story> findById(Long id) {
		return storyRepository.findById(id);
	}

	/*
	 * Update a User from table
	 */
	public Story update(Story story, Long id) {
		return this.save(story, id);
	}
}
