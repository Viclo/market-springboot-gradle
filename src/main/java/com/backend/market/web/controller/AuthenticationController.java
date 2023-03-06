package com.backend.market.web.controller;

import com.backend.market.domain.dto.AuthenticationRequest;
import com.backend.market.persistence.dao.UserDao;
import com.backend.market.web.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationManager authenticationManager;
  private final UserDao userDao;
  private final JwtUtils jwtUtils;

  @PostMapping("/authenticate")
  public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
    );
    final UserDetails userDetails = userDao.findUserByEmail(authenticationRequest.getEmail());
    if (userDetails != null) {
      return ResponseEntity.ok(jwtUtils.generateToke(userDetails));
    }
    return  ResponseEntity.status(400).body("Some error has occurred.");
  }
}
