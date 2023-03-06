package com.backend.market.web.controller;

import com.backend.market.domain.Product;
import com.backend.market.domain.dto.AuthenticationRequest;
import com.backend.market.persistence.dao.UserDao;
import com.backend.market.web.security.JwtUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
  @Operation(summary = "Get a JWT.", responses = {
      @ApiResponse(responseCode = "200", description = "Successful Operation.", content = @Content(schema = @Schema(implementation = String.class))),
      @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content(schema = @Schema(hidden = true))),
      @ApiResponse(responseCode = "404", description = "User not found.", content = @Content)
  })
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
