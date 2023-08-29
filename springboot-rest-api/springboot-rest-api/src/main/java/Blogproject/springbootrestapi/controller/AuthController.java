package Blogproject.springbootrestapi.controller;

import Blogproject.springbootrestapi.payload.JWTAuthResponse;
import Blogproject.springbootrestapi.payload.LoginDto;
import Blogproject.springbootrestapi.payload.RegisterDto;
import Blogproject.springbootrestapi.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    //Build login rest API
    @PostMapping(value = {"/login","/signin"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto)
    {
        String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    //build register api
    @PostMapping(value ={"/register","/signup"})
    public ResponseEntity<String> register (@RequestBody RegisterDto registerDto)
    {
         String response =   authService.register(registerDto);
         return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
