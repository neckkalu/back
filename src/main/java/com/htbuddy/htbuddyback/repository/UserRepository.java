package com.htbuddy.htbuddyback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.htbuddy.htbuddyback.entity.UserEntity;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
  boolean existsByEmailId(String emailId);
  boolean existsByNickname(String nickname);
  boolean existsByTelNumber(String telNumber);

  UserEntity findByEmailId(String emailId);

  @Query(
    value=
    "SELECT * " +
    "FROM member " +
    "WHERE email_id IN ( " +
      "SELECT email_id " +
      "WHERE board_Id = ?1" +
    ")", nativeQuery=true
  )
  List<UserEntity> getFavoriteList(Integer boardNumber);
}
