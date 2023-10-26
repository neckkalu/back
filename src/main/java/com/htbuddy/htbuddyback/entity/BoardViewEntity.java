package com.htbuddy.htbuddyback.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="community")
@Table(name="community")
public class BoardViewEntity {
  @Id
  private int boardNumber;
  private String emailId;
  private String title;
  private String content;
  private String creationDate;
  private int viewCount;
}