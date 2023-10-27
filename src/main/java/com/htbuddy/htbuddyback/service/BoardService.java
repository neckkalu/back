package com.htbuddy.htbuddyback.service;

import org.springframework.http.ResponseEntity;

import com.htbuddy.htbuddyback.dto.request.board.PatchBoardRequestDto;
import com.htbuddy.htbuddyback.dto.request.board.PostBoardRequestDto;
import com.htbuddy.htbuddyback.dto.request.board.PostCommentRequestDto;
import com.htbuddy.htbuddyback.dto.response.board.PatchBoardResponseDto;
import com.htbuddy.htbuddyback.dto.response.board.PostBoardResponseDto;
import com.htbuddy.htbuddyback.dto.response.board.PostCommentResponseDto;
import com.htbuddy.htbuddyback.dto.response.board.DeleteBoardResponseDto;
import com.htbuddy.htbuddyback.dto.response.board.GetBoardResponseDto;
import com.htbuddy.htbuddyback.dto.response.board.GetCommentListResponseDto;
import com.htbuddy.htbuddyback.dto.response.board.GetCurrentBoardResponseDto;
import com.htbuddy.htbuddyback.dto.response.board.GetSearchBoardResponseDto;
import com.htbuddy.htbuddyback.dto.response.board.GetUserListResponseDto;

public interface BoardService {
  
  // method : 최신 게시물 리스트 불러오기 메서드 //
  ResponseEntity<? super GetCurrentBoardResponseDto> getCurrentBoard(Integer section);
  // method : 게시물 불러오기 메서드 //
  ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
  // method : 검색 게시물 리스트 불러오기 //
  ResponseEntity<? super GetSearchBoardResponseDto> getSearchBoard(String searchWord, String relataionWord);
  // method : 특정 게시물의 댓글 리스트 불러오기 //
  ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber);
  // method : 특정 유저의 게시물 리스트 불러오기 //
  ResponseEntity<? super GetUserListResponseDto> getUserList(String email);
  // method : 게시물 작성 메서드 //
  ResponseEntity<? super PostBoardResponseDto> postBoard(String email, PostBoardRequestDto dto);
  // method : 댓글 작성 메서드 //
  ResponseEntity<? super PostCommentResponseDto> postComment(Integer boardNumber, String email, PostCommentRequestDto dto);
  // method : 게시물 수정 메서드 //
  ResponseEntity<? super PatchBoardResponseDto> patchBoard(Integer boardNumber, String email, PatchBoardRequestDto dto);
  // method : 게시물 삭제 메서드 //
  ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Integer boardNumber, String email);

}
