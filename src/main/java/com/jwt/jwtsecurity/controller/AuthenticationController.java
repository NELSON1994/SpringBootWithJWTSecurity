package com.jwt.jwtsecurity.controller;

import com.jwt.jwtsecurity.model.AuthenticationRequest;
import com.jwt.jwtsecurity.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    private String generateToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );// validate username and password
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Invalid Username/Password");
        }
        return jwtUtil.generateToken(authenticationRequest.getUsername());
    }
}
