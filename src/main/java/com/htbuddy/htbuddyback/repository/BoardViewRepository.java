package com.htbuddy.htbuddyback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htbuddy.htbuddyback.entity.BoardViewEntity;


@Repository
public interface BoardViewRepository extends JpaRepository<BoardViewEntity, Integer> {
  BoardViewEntity findByBoardNumber(Integer boardNumber);
  
  List<BoardViewEntity> findByTitleContainsOrContentsContainsOrderByWriteDatetimeDesc(String title, String contents);
  List<BoardViewEntity> findByWriterEmailOrderByWriteDatetimeDesc(String email);
}
