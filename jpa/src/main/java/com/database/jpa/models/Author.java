package com.database.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NamedQuery(
        name = "Author.findByNamedQuery",
        query = "select a from Author a where a.age >=:age"
)
public class Author extends BaseEntity{


  private String firstName;

  private String lastName;
  @Column(unique = true,nullable = false)
  private String email;

  private int age;
  @ManyToMany(mappedBy = "authors")
  private List<Course> courses;


}
