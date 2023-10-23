package com.htbuddy.htbuddyback.dto.response;

public interface ResponseCode {

  // HTTP Status 200 (성공)
  String SUCCESS = "SU";

  // HTTP Status 400
  String VALIDATION_FAILED = "VF";
  String EXISTED_EMAIL = "EE";
  String EXISTED_TELNUMBER = "ET";
  String EXISTED_NICKNAME = "EN";
  String NO_EXISTED_BOARD_NUMBER = "NB";
  String NO_EXISTED_USER = "NU";
  String NO_EXISTED_CHATTINGROOM = "NC";

  // HTTP Status 401
  String SIGN_IN_FAIL = "SF";
  String AUTHORIZATION_FAIL = "AF";

  // HTTP Status 403
  String NO_PERMISSION = "NP";

  // HTTP Status 500
  String DATABASE_ERROR = "DE";
}
