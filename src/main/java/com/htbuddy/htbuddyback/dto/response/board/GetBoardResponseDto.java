package com.htbuddy.htbuddyback.dto.response.board;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.htbuddy.htbuddyback.dto.response.ResponseCode;
import com.htbuddy.htbuddyback.dto.response.ResponseDto;
import com.htbuddy.htbuddyback.dto.response.ResponseMessage;
import com.htbuddy.htbuddyback.entity.BoardViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetBoardResponseDto extends ResponseDto {
  private int boardNumber;
  private String title;
  private String contents;
  private String imageUrl;
  private String writeDatetime;
  private String writerEmail;
  private String writerNickname;
  private String writerProfileImage;

  private GetBoardResponseDto(String code, String message, BoardViewEntity boardViewEntity) {
    super(code, message);
    this.boardNumber = boardViewEntity.getBoardNumber();
    this.writerEmail = boardViewEntity.getEmailId();
    this.title = boardViewEntity.getTitle();
    this.contents = boardViewEntity.getContent();
    this.writeDatetime = boardViewEntity.getCreationDate();
  }

  public static ResponseEntity<GetBoardResponseDto> success(BoardViewEntity boardViewEntity) {
    GetBoardResponseDto result = new GetBoardResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, boardViewEntity);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedBoard() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_BOARD_NUMBER, ResponseMessage.NO_EXISTED_BOARD_NUMBER);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
}
