package com.rosu.onlinestore.controller;

import com.rosu.onlinestore.model.User;
import com.rosu.onlinestore.security.DatabaseUserDetailsService;
import com.rosu.onlinestore.security.JwtProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private final JwtProvider jwtProvider;

    @Autowired
    private final DatabaseUserDetailsService userDetailsService;


    @Autowired
    public LoginController(AuthenticationManager authenticationManager, JwtProvider jwtProvider, DatabaseUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User userAuthenticationRequest) throws Exception {
        System.out.println(userAuthenticationRequest.getEmail());
        authenticate(userAuthenticationRequest.getEmail(), userAuthenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(userAuthenticationRequest.getEmail());
        final String token = jwtProvider.createToken(userDetails.getUsername());
        return ResponseEntity.ok(token);
    }
   private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            log.info("Login successfull");
        } catch (DisabledException e) {
            log.error("User disabled");
            throw new Exception("User disabled", e);
        } catch (BadCredentialsException e) {
            log.error("Invalid Credentials");
            throw new Exception("Invalid Credentials", e);
        }
    }
}









