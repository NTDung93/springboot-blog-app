package ntd.springboot.blogapprestapi.service;

import ntd.springboot.blogapprestapi.model.payload.LoginDto;
import ntd.springboot.blogapprestapi.model.payload.SignupDto;

public interface AuthService {
    String login(LoginDto loginDto);
    String signup(SignupDto signupDto);
}
