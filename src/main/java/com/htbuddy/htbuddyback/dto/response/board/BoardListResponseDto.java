package com.htbuddy.htbuddyback.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import com.htbuddy.htbuddyback.entity.BoardViewEntity;
import com.htbuddy.htbuddyback.entity.resultSet.BoardListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardListResponseDto {
  private int boardNumber;
  private String title;
  private String content;
  private int viewCount;
  private String creationDate;

  public BoardListResponseDto(BoardListResultSet resultSet) {
    this.boardNumber = resultSet.getBoardNumber();
    this.title = resultSet.getTitle();
    this.content = resultSet.getContents();
    this.viewCount = resultSet.getViewCount();
    this.creationDate = resultSet.getCreationDate();
  }

  public BoardListResponseDto(BoardViewEntity boardViewEntity) {
    this.boardNumber = boardViewEntity.getBoardNumber();
    this.title = boardViewEntity.getTitle();
    this.content = boardViewEntity.getContent();
    this.viewCount = boardViewEntity.getViewCount();
    this.creationDate = boardViewEntity.getCreationDate();
  }

  public static List<BoardListResponseDto> copyList(List<BoardListResultSet> resultSets) {
    List<BoardListResponseDto> boardList = new ArrayList<>();

    for (BoardListResultSet resultSet: resultSets) {
      BoardListResponseDto board = new BoardListResponseDto(resultSet);
      boardList.add(board);
    }

    return boardList;
  }

  public static List<BoardListResponseDto> copyEntityList(List<BoardViewEntity> boardViewEntities) {
    List<BoardListResponseDto> boardList = new ArrayList<>();

    for (BoardViewEntity entity: boardViewEntities) {
      BoardListResponseDto board = new BoardListResponseDto(entity);
      boardList.add(board);
    }

    return boardList;
  }
}
