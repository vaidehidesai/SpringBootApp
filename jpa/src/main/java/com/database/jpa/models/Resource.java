package com.database.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
