package com.htbuddy.htbuddyback.entity.resultSet;

public interface BoardListResultSet {
  int getBoardNumber();
  String getTitle();
  String getContents();
  int getViewCount();
  String getCreationDate();
}
