package com.database.jpa.repositories;

import com.database.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
  @Modifying
  @Transactional
  @Query("update Author a set a.age = :age where a.id=:id")
  int updateAge(int age,int id);

  List<Author> findAllByFirstName(String fn);

  List<Author> findAllByFirstNameIgnoreCase(String fn);

  List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

  List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);

  List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);
}
