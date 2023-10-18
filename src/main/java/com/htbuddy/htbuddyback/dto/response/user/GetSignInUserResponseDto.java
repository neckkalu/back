package com.htbuddy.htbuddyback.dto.response.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.htbuddy.htbuddyback.common.ResponseCode;
import com.htbuddy.htbuddyback.common.ResponseMessage;
import com.htbuddy.htbuddyback.dto.response.ResponseDto;
import com.htbuddy.htbuddyback.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetSignInUserResponseDto extends ResponseDto {
  
  private String email;
  private String nickname;
  private String profileImageUrl;

  private GetSignInUserResponseDto(String code, String message, UserEntity userEntity) {
    super(code, message);
    this.email = userEntity.getEmail();
    this.nickname = userEntity.getNickname();
    this.profileImageUrl = userEntity.getProfileImageUrl();
  }

  public static ResponseEntity<GetSignInUserResponseDto> success(UserEntity userEntity) {
    GetSignInUserResponseDto result = new GetSignInUserResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, userEntity);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedUser() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
  }

}
