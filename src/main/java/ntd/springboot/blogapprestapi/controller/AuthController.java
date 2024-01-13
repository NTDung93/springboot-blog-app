package ntd.springboot.blogapprestapi.controller;

import ntd.springboot.blogapprestapi.model.payload.JWTAuthResponse;
import ntd.springboot.blogapprestapi.model.payload.LoginDto;
import ntd.springboot.blogapprestapi.model.payload.SignupDto;
import ntd.springboot.blogapprestapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return  ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping(value = {"/signup", "/register"})
    public ResponseEntity<String> signup(@RequestBody SignupDto signupDto){
        String response = authService.signup(signupDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
