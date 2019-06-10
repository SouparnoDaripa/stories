package com.daripa.stories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StoriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoriesApplication.class, args);
	}

}
