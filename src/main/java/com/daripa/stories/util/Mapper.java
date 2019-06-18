package com.daripa.stories.util;

import org.modelmapper.ModelMapper;

import com.daripa.stories.model.Story;
import com.daripa.stories.model.User;
import com.daripa.stories.payload.StoryResponse;

public class Mapper {
	public static StoryResponse mapStoryToStoryResponse(Story story, User author) {
		ModelMapper modelMapper = new ModelMapper();
		StoryResponse storyResponse = modelMapper.map(story, StoryResponse.class);
		storyResponse.setAuthorName(author.getFirstName() + " " + author.getLastName());
		storyResponse.setAuthorShortName(author.getUsername());
		storyResponse.setAuthorAvatar(author.getAvatar());
		return storyResponse;
	}
}
