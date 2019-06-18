package com.daripa.stories.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.daripa.stories.exception.BadRequestException;
import com.daripa.stories.exception.ResourceNotFoundException;
import com.daripa.stories.model.Story;
import com.daripa.stories.model.User;
import com.daripa.stories.payload.PagedResponse;
import com.daripa.stories.payload.StoryResponse;
import com.daripa.stories.repository.StoryRepository;
import com.daripa.stories.repository.UserRepository;
import com.daripa.stories.security.UserPrincipal;
import com.daripa.stories.util.AppConstants;
import com.daripa.stories.util.Mapper;

public class StoryService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	StoryRepository storyRepository;

	private static final Logger logger = LoggerFactory.getLogger(StoryService.class);

	// Fetch all the stories
	public PagedResponse<StoryResponse> getAllStories(UserPrincipal currentUser, int page, int size) {
		validatePageNumberAndSize(page, size);

		// Retrieve the stories
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
		Page<Story> stories = storyRepository.findAll(pageable);

		if (stories.getNumberOfElements() == 0) {
			return new PagedResponse<>(Collections.emptyList(), stories.getNumber(), stories.getSize(),
					stories.getTotalElements(), stories.getTotalPages(), stories.isLast());
		}

		// Map Stories to storyResponse
		List<Long> storyIds = stories.map(Story::getStoryId).getContent();
		Map<Long, User> authorMap = getStoryAuthorMap(stories.getContent());

		List<StoryResponse> storyResponses = stories.map(story -> {
			return Mapper.mapStoryToStoryResponse(story, authorMap.get(story.getCreatedBy()));
		}).getContent();

		return new PagedResponse<>(storyResponses, stories.getNumber(), stories.getSize(), stories.getTotalElements(),
				stories.getTotalPages(), stories.isLast());
	}

	// Fetch All Stories By CurrentUser
	public PagedResponse<StoryResponse> getAllStoriesByAuthor(String username, UserPrincipal currentUser, int page,
			int size) {
		validatePageNumberAndSize(page, size);

		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

		// Retrieve the stories
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
		Page<Story> stories = storyRepository.findByCreatedBy(user.getId(), pageable);

		if (stories.getNumberOfElements() == 0) {
			return new PagedResponse<>(Collections.emptyList(), stories.getNumber(), stories.getSize(),
					stories.getTotalElements(), stories.getTotalPages(), stories.isLast());
		}

		// Map Stories to storyResponse
		List<Long> storyIds = stories.map(Story::getStoryId).getContent();
		Map<Long, User> authorMap = getStoryAuthorMap(stories.getContent());

		List<StoryResponse> storyResponses = stories.map(story -> {
			return Mapper.mapStoryToStoryResponse(story, user);
		}).getContent();

		return new PagedResponse<>(storyResponses, stories.getNumber(), stories.getSize(), stories.getTotalElements(),
				stories.getTotalPages(), stories.isLast());
	}

	Map<Long, User> getStoryAuthorMap(List<Story> stories) {
		// Get Poll Creator details of the given list of polls
		List<Long> authorIds = stories.stream().map(Story::getCreatedBy).distinct().collect(Collectors.toList());

		List<User> authors = userRepository.findByIdIn(authorIds);
		Map<Long, User> authorMap = authors.stream().collect(Collectors.toMap(User::getId, Function.identity()));

		return authorMap;
	}

	private void validatePageNumberAndSize(int page, int size) {
		if (page < 0) {
			throw new BadRequestException("Page number cannot be less than zero.");
		}

		if (size > AppConstants.MAX_PAGE_SIZE) {
			throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
		}
	}

}
