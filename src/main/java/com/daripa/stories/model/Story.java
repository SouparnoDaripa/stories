package com.daripa.stories.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.daripa.stories.model.audit.UserDateAudit;

@Entity
@Table(name = "stories")
@EntityListeners(AuditingEntityListener.class)
public class Story extends UserDateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long storyId;

	/*
	 * Short Name of the Story
	 */
	private String shortName;

	/*
	 * Title of the Story
	 */
	@Column(nullable = false)
	private String title;

	/*
	 * Content of the Story
	 */
	@Column(nullable = false)
	private String content;

	/*
	 * Story Topic
	 */
	@Column(nullable = false)
	private String topic;

	/*
	 * Tags
	 */
	private String tags;

	/*
	 * Story Url
	 */
	private String storyUrl;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	public Long getStoryId() {
		return storyId;
	}

	public void setStoryId(Long storyId) {
		this.storyId = storyId;
	}

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

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getStoryUrl() {
		return storyUrl;
	}

	public void setStoryUrl(String storyUrl) {
		this.storyUrl = storyUrl;
	}

	public User getAuthor() {
		return user;
	}

	public void setAuthor(User author) {
		this.user = author;
	}
}
