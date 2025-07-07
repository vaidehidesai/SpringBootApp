package com.database.jpa;

import com.database.jpa.models.Video;
import com.database.jpa.repositories.AuthorRepository;
import com.database.jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	// @Bean
	public CommandLineRunner commandLineRunner(AuthorRepository repo, VideoRepository videoRepository){
		return args -> {
			/*var author = Author.builder()
							.firstname("Vaidehi")
							.lastname("Desai")
							.age(23)
							.email("contact@gmail.com")
							.build();
			repo.save(author);*/

			var video = Video.builder()
							.name("abc")
							.length(7)
							.build();
			videoRepository.save(video);
		};

	}

}
