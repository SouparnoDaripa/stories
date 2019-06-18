package com.daripa.stories.payload;

import java.util.List;

public class StoryResponse {
	/*
	 * Short Name of the Story
	 */
	private String shortName;

	/*
	 * Title of the Story
	 */
	private String title;

	/*
	 * Content of the Story
	 */
	private String content;

	/*
	 * Story Topic
	 */
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
	 * Author name
	 */
	private String authorName;

	/*
	 * Author short name
	 */
	private String authorShortName;

	/*
	 * Author name
	 */
	private String authorAvatar;

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

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorShortName() {
		return authorShortName;
	}

	public void setAuthorShortName(String authorShortName) {
		this.authorShortName = authorShortName;
	}

	public String getAuthorAvatar() {
		return authorAvatar;
	}

	public void setAuthorAvatar(String authorAvatar) {
		this.authorAvatar = authorAvatar;
	}
}
