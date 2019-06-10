package com.daripa.stories.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.daripa.stories.model.Story;
import com.daripa.stories.repository.StoryRepository;

public class StoryDAO {

	@Autowired
	StoryRepository storyRepository;

	/*
	 * Save a Story in table
	 */
	public Story save(Story story) {
		return storyRepository.save(story);
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
	 * Fetches all stories by topic from table
	 */
	public List<Story> findByTopic(String topic) {
		return storyRepository.findByTopic(topic);
	}

	/*
	 * Fetches all stories by tags from table
	 */
//	public List<Story> findByTags() {
//		return storyRepository.findByTags();
//	}

	/*
	 * Fetches all stories by author from table
	 */
	public List<Story> findByAuthorId(Long id) {
		return storyRepository.findByAuthorId(id);
	}

	/*
	 * Update a User from table
	 */
	public Story update(Story story) {
		return this.save(story);
	}
}
