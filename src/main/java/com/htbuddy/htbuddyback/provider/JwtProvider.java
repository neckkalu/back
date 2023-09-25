package com.htbuddy.htbuddyback.provider;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import io.jsonwebtoken.Jwts;


@Component 
public class JwtProvider {

  private String secretKey = "S3cr3tK3y";

  public String create(String email) {

    Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

    String jwt = Jwts

  }

}