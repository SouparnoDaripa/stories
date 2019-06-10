package com.daripa.stories.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daripa.stories.dao.StoryDAO;
import com.daripa.stories.model.Story;

@RestController
@RequestMapping("/stories")
public class StoryController {

	@Autowired
	StoryDAO storyDAO;

	/*
	 * Save a story
	 */
	@PostMapping("/create")
	public Story createStory(@Valid @RequestBody Story story) {
		return storyDAO.save(story);
	}

	/*
	 * Get the list of all stories
	 */
	@GetMapping("/query")
	public Story getStories(@Valid @RequestBody Story story) {
		return storyDAO.save(story);
	}

	/*
	 * Get the list of stories
	 */
	@GetMapping("/query/1/{topic}")
	public Story getStoriesByTopic(@Valid @RequestBody Story story, @PathVariable(value = "topic") String topic) {
		return storyDAO.save(story);
	}

	/*
	 * Get the list of stories
	 */
	@GetMapping("/query/2/{id}")
	public Story getStoriesByTopic(@Valid @RequestBody Story story, @PathVariable(value = "id") Long noteId) {
		return storyDAO.save(story);
	}
}
