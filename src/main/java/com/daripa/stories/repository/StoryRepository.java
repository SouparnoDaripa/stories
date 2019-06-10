package com.daripa.stories.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daripa.stories.model.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {

	List<Story> findByTopic(String topic);

	List<Story> findByAuthorId(Long authorId);

	// List<Story> findByTags(String tag);
}
