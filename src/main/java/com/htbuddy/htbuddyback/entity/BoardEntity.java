package com.htbuddy.htbuddyback.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.htbuddy.htbuddyback.dto.request.board.PatchBoardRequestDto;
import com.htbuddy.htbuddyback.dto.request.board.PostBoardRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="community")
@Table(name="community")
public class BoardEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int boardNumber;
  private String emailId;
  private String title;
  private String content;
  private String creationDate;
  private int viewCount;

  public BoardEntity(String writerEmail, PostBoardRequestDto dto) {
    Date now = Date.from(Instant.now());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String writeDatetime = simpleDateFormat.format(now);

    this.title = dto.getTitle();
    this.content = dto.getContents();
    this.creationDate = writeDatetime;
    this.emailId = writerEmail;
  }

  public void patch(PatchBoardRequestDto dto) {
    this.title = dto.getTitle();
    this.content = dto.getContents();
  }

  public void increaseViewCount() {
    this.viewCount++;
  }

}

