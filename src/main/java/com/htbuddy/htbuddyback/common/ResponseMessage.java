package com.htbuddy.htbuddyback.common;

public class ResponseMessage {

  // HTTP Status 200 (성공)
  String SUCCESS = "Success";

  // HTTP Status 400
  String VALIDATION_FAILED = "Valdation Failed";
  String EXISTED_EMAIL = "Existed Email";
  String EXISTED_TELNUMBER = "Existed telNumber";
  String EXISTED_NICKNAME = "Existed nickname";
  String NO_EXISTED_BOARD_NUMBER = "No Existed Board Number";
  String NO_EXISTED_USER = "No Existed User";
  String NO_EXISTED_CHATTINGROOM = "No Existed ChattingRoom";

  // HTTP Status 401
  String SIGN_IN_FAIL = "Sign In Failed";
  String AUTHORIZATION_FAIL = "Authorization Fail";

  // HTTP Status 403
  String NO_PERMISSION = "No Permission";

  // HTTP Status 500
  String DATABASE_ERROR = "Database Error";
  
}
