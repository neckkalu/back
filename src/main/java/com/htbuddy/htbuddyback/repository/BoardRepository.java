package com.htbuddy.htbuddyback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.htbuddy.htbuddyback.entity.BoardEntity;
import com.htbuddy.htbuddyback.entity.resultSet.BoardListResultSet;


@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
  boolean existsByBoardNumber(Integer boardNumber);

  BoardEntity findByBoardNumber(Integer boardNumber);

  @Query(
    value=
    "SELECT " +
    "B.board_Id AS boardId, " +
    "B.title AS title, " +
    "B.content AS content, " +
    "B.view_Count AS viewCount, " +
    "B.creation_Date AS  creationDate, " +
    "U.profile_image_url AS writerProfileImage, " +
    "U.nickname AS writerNickname " +
    "FROM board AS B " +
    "INNER JOIN member AS U " +
    "ON B.email_Id = U.email_id " +
    "ORDER BY B.creation_Date DESC " +
    "LIMIT ?1, 50",
    nativeQuery=true
  )
  List<BoardListResultSet> getCurrentList(Integer section);
}
