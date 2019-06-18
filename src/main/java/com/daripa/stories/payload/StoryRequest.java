package com.daripa.stories.payload;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StoryRequest {
	/*
	 * Short Name of the Story
	 */
	@NotBlank
	@Size(max = 100)
	private String shortName;

	/*
	 * Title of the Story
	 */
	@NotBlank
	@Size(max = 120)
	private String title;

	/*
	 * Content of the Story
	 */
	@NotBlank
	private String content;

	/*
	 * Story Topic
	 */
	@NotBlank
	@Size(min = 3, max = 15)
	private String topic;

	/*
	 * Tags
	 */
	private List<String> tags;

	/*
	 * Story Url
	 */
	private String storyUrl;

	/*
	 * Author Id
	 */
	@Valid
	private Long userId;

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getStoryUrl() {
		return storyUrl;
	}

	public void setStoryUrl(String storyUrl) {
		this.storyUrl = storyUrl;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
