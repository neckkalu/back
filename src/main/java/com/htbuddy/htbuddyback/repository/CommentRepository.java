package com.htbuddy.htbuddyback.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.htbuddy.htbuddyback.entity.CommentEntity;
import com.htbuddy.htbuddyback.entity.resultSet.CommentListResultSet;


@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
  
  @Query(
    value=
    "SELECT " +
      "U.profile_image_url AS profileImageUrl, " +
      "U.nickname AS nickname, " +
      "C.content AS content, " +
      "C.creation_Date AS creationDate " +
    "FROM comment AS C INNER JOIN member AS U " +
    "ON C.email_Id = U.email_id " +
    "WHERE board_Id = ?1 " +
    "ORDER BY C.creation_Date",
    nativeQuery=true
  )
  List<CommentListResultSet> getCommentList(Integer boardNumber);

  @Transactional
  void deleteByBoardNumber(Integer boardNumber);

}
