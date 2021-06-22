package com.hoank.config.multipledb.admissions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admission")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admission {

  @Id
  private int id;
  private String description;
}
