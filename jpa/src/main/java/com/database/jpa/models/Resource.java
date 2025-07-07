package com.database.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// @DiscriminatorColumn(name = "resource_type")
public class Resource {
  @Id
  @GeneratedValue
  private Integer id;

  private String name;

  private int size;

  private String url;

  @OneToOne
  @JoinColumn(name ="lecture_id")
  private Lecture lecture;
}
