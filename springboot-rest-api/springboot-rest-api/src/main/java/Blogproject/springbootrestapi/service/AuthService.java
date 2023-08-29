package Blogproject.springbootrestapi.service;

import Blogproject.springbootrestapi.payload.LoginDto;
import Blogproject.springbootrestapi.payload.RegisterDto;

public interface AuthService {

    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
