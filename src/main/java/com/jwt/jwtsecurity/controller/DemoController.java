package com.jwt.jwtsecurity.controller;

import com.jwt.jwtsecurity.model.AuthenticationRequest;
import com.jwt.jwtsecurity.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String wel(){
        return "Welcome Nelson";
    }

    @GetMapping("/inside")
    public String wel2(){
        return "YOU ARE NOW INSIDE THE APPLICATION";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthenticationRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }
}
