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
public class Author extends BaseEntity{


  private String firstname;

  private String lastname;
  @Column(unique = true,nullable = false)
  private String email;

  private int age;
  @ManyToMany(mappedBy = "authors")
  private List<Course> courses;


}
