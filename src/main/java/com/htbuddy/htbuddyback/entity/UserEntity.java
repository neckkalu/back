package com.htbuddy.htbuddyback.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.htbuddy.htbuddyback.dto.request.auth.SignUpRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="member")
@Table(name="member")
public class UserEntity {
  @Id
  private String emailId;
  private String password;
  private String nickname;
  private String telNumber;
  private String address;
  private String addressDetail;
  private String profileImageUrl;

  public UserEntity(SignUpRequestDto dto) {
    this.emailId = dto.getEmail();
    this.password = dto.getPassword();
    this.nickname = dto.getNickname();
    this.telNumber = dto.getTelNumber();
    this.address = dto.getAddress();
    this.addressDetail = dto.getAddressDetail();
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public void setProfileImageUrl(String profileImageUrl) {
    this.profileImageUrl = profileImageUrl;
  }
}
