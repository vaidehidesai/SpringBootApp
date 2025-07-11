package com.database.jpa;

import com.database.jpa.models.Author;
import com.database.jpa.repositories.AuthorRepository;
import com.database.jpa.repositories.VideoRepository;
import com.database.jpa.specification.AuthorSpecification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository repo, VideoRepository videoRepository){
		return args -> {
			/*for(int i=0;i<50;i++){
				var author = Author.builder()
								.firstName("Vaidehi"+i)
								.lastName("Desai"+i+i)
								.age(23 + i)
								.email("contact"+i+"@gmail.com")
								.build();
				repo.save(author);
			}*/
			/*var author = Author.builder()
							.id(1)
							.firstName("Gaurang")
							.lastName("Desai")
							.age(23)
							.email("contact@gmail.com")
							.build();
			//repo.save(author);

			//repo.updateAge(45,1);

			// repo.findByNamedQuery(45).forEach(System.out::println);

			/*var video = Video.builder()
							.name("abc")
							.length(7)
							.build();
			videoRepository.save(video);*/

			Specification<Author> spec = Specification
							.where(AuthorSpecification.hasAge(45)
											.and(AuthorSpecification.firstnameContains("Va")));

			repo.findAll(spec).forEach(System.out::println);
		};

	}

}
