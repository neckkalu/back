package com.htbuddy.htbuddyback.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htbuddy.htbuddyback.dto.request.board.PatchBoardRequestDto;
import com.htbuddy.htbuddyback.dto.request.board.PostBoardRequestDto;
import com.htbuddy.htbuddyback.dto.request.board.PostCommentRequestDto;
import com.htbuddy.htbuddyback.dto.response.board.PatchBoardResponseDto;
import com.htbuddy.htbuddyback.dto.response.board.PostBoardResponseDto;
import com.htbuddy.htbuddyback.dto.response.board.PostCommentResponseDto;
import com.htbuddy.htbuddyback.service.BoardService;
import com.htbuddy.htbuddyback.dto.response.board.DeleteBoardResponseDto;
import com.htbuddy.htbuddyback.dto.response.board.GetBoardResponseDto;
import com.htbuddy.htbuddyback.dto.response.board.GetCommentListResponseDto;
import com.htbuddy.htbuddyback.dto.response.board.GetCurrentBoardResponseDto;
import com.htbuddy.htbuddyback.dto.response.board.GetSearchBoardResponseDto;
import com.htbuddy.htbuddyback.dto.response.board.GetUserListResponseDto;

import lombok.RequiredArgsConstructor;

// contorller : 게시물 컨트롤러 //
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

  private final BoardService boardService;
  

  // API : 최신 게시물 리스트 불러오기 메서드 //
  @GetMapping("/current-board/{section}")
  public ResponseEntity<? super GetCurrentBoardResponseDto> getCurrentBoard(
    @PathVariable(value="section", required=true) Integer section
  ) {
    ResponseEntity<? super GetCurrentBoardResponseDto> response = boardService.getCurrentBoard(section);
    return response;
  }

  // API : 게시물 불러오기 메서드 //
  @GetMapping("/{boardNumber}")
  public ResponseEntity<? super GetBoardResponseDto> getBoard(
    @PathVariable(value="boardNumber", required=true) Integer boardNumber
  ) {
    ResponseEntity<? super GetBoardResponseDto> response = boardService.getBoard(boardNumber);
    return response;
  }

  // API : 검색 게시물 리스트 불러오기 메서드 //
  @GetMapping(value={"/search/{searchWord}", "/search/{searchWord}/{relationWord}"})
  public ResponseEntity<? super GetSearchBoardResponseDto> getSearchBoard(
    @PathVariable(value="searchWord", required=true) String searchWord,
    @PathVariable(value="relationWord", required=false) String relationWord
  ) {
    ResponseEntity<? super GetSearchBoardResponseDto> response = 
      boardService.getSearchBoard(searchWord, relationWord);
    return response;
  }

  // API : 특정 게시물의 댓글 리스트 불러오기 메서드 //
  @GetMapping("/{boardNumber}/comment-list")
  public ResponseEntity<? super GetCommentListResponseDto> getCommentList(
    @PathVariable(value="boardNumber", required=true) Integer boardNumber
  ) {
    ResponseEntity<? super GetCommentListResponseDto> response = boardService.getCommentList(boardNumber);
    return response;
  }

  // API : 특정 유저의 게시물 리스트 불러오기 메서드 //
  @GetMapping("/user-list/{email}")
  public ResponseEntity<? super GetUserListResponseDto> getUserList(
    @PathVariable(value="email", required=true) String email
  ) {
    ResponseEntity<? super GetUserListResponseDto> response = boardService.getUserList(email);
    return response;
  }

  // API : 게시물 작성 메서드 //
  @PostMapping("")
  public ResponseEntity<? super PostBoardResponseDto> postBoard(
    @AuthenticationPrincipal String email,
    @RequestBody @Valid PostBoardRequestDto requestBody
  ) {
    ResponseEntity<? super PostBoardResponseDto> response = boardService.postBoard(email, requestBody);
    return response;
  }

  // API : 댓글 작성 메서드 //
  @PostMapping("/{boardNumber}/comment")
  public ResponseEntity<? super PostCommentResponseDto> postComment(
    @AuthenticationPrincipal String email,
    @PathVariable(value="boardNumber", required=true) Integer boardNumber,
    @RequestBody @Valid PostCommentRequestDto requestBody
  ) {
    ResponseEntity<? super PostCommentResponseDto> response = boardService.postComment(boardNumber, email, requestBody);
    return response;
  }


  // API : 게시물 수정 메서드 //
  @PatchMapping("/{boardNumber}")
  public ResponseEntity<? super PatchBoardResponseDto> patchBoard(
    @AuthenticationPrincipal String email,
    @PathVariable(value="boardNumber", required=true) Integer boardNumber,
    @RequestBody @Valid PatchBoardRequestDto requestBody
  ) {
    ResponseEntity<? super PatchBoardResponseDto> response = boardService.patchBoard(boardNumber, email, requestBody);
    return response;
  }

  // API : 게시물 삭제 메서드 //
  @DeleteMapping("/{boardNumber}")
  public ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(
    @AuthenticationPrincipal String email,
    @PathVariable(value="boardNumber", required=true) Integer boardNumber
  ) {
    ResponseEntity<? super DeleteBoardResponseDto> response = boardService.deleteBoard(boardNumber, email);
    return response;
  }

}
