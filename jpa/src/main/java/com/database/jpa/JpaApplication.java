package com.database.jpa;

import com.database.jpa.models.Author;
import com.database.jpa.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	//@Bean
	/*public CommandLineRunner commandLineRunner(AuthorRepository repo){
		return args -> {
			var author = Author.builder()
							.firstname("Vaidehi")
							.lastname("Desai")
							.age(23)
							.email("contact@gmail.com")
							.build();
			repo.save(author);
		};

	}*/

}
