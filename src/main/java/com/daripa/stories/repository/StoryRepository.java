package com.daripa.stories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.daripa.stories.model.Story;

public interface StoryRepository extends JpaRepository<Story, Long> {

	Page<Story> findByTopic(String topic, Pageable pageable);

	Page<Story> findByCreatedBy(Long userId, Pageable pageable);

	long countByCreatedBy(Long userId);

	// List<Story> findByTags(String tag);
}
