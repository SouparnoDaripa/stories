package com.daripa.stories.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daripa.stories.model.Story;

public interface StoryRepository extends JpaRepository<Story, Long> {

	List<Story> findByTopic(String topic);

	List<Story> findByUserId(Long authorId);

	// List<Story> findByTags(String tag);
}
