package ntd.springboot.blogapprestapi.service.impl;

import ntd.springboot.blogapprestapi.model.entity.Role;
import ntd.springboot.blogapprestapi.model.entity.User;
import ntd.springboot.blogapprestapi.model.exception.BlogApiException;
import ntd.springboot.blogapprestapi.model.payload.LoginDto;
import ntd.springboot.blogapprestapi.model.payload.SignupDto;
import ntd.springboot.blogapprestapi.repository.RoleRepository;
import ntd.springboot.blogapprestapi.repository.UserRepository;
import ntd.springboot.blogapprestapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository,
                           RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "User logged-in successfully!";
    }

    @Override
    public String signup(SignupDto signupDto) {

        // add check if username already exists
        if (userRepository.existsByUsername(signupDto.getUsername())) {
            throw new BlogApiException(HttpStatus.BAD_REQUEST, "Username is already exist!");
        }

        // add check if email already exists
        if (userRepository.existsByEmail(signupDto.getEmail())) {
            throw new BlogApiException(HttpStatus.BAD_REQUEST, "Email is already exist!");
        }

        User user = new User();
        user.setUsername(signupDto.getUsername());
        user.setEmail(signupDto.getEmail());
        user.setPassword(passwordEncoder.encode(signupDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new BlogApiException(HttpStatus.BAD_REQUEST, "User Role not set."));
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);

        return "User registered successfully!";
    }
}
