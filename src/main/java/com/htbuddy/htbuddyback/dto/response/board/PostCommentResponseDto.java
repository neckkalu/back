package com.htbuddy.htbuddyback.dto.response.board;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.htbuddy.htbuddyback.dto.response.ResponseCode;
import com.htbuddy.htbuddyback.dto.response.ResponseDto;
import com.htbuddy.htbuddyback.dto.response.ResponseMessage;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostCommentResponseDto extends ResponseDto {
  
  private PostCommentResponseDto (String code, String message) {
    super(code, message);
  }

  public static ResponseEntity<PostCommentResponseDto> success() {
    PostCommentResponseDto result = new PostCommentResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedUser() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedBoard() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_BOARD_NUMBER, ResponseMessage.NO_EXISTED_BOARD_NUMBER);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

}