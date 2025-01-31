package com.hacknimeto.authorization_service.services;

import com.hacknimeto.authorization_service.entities.AuthRequest;
import com.hacknimeto.authorization_service.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    Logger logger = LoggerFactory.getLogger(AuthService.class);

    private final UserClientService userClientService;
    private final JwtService jwtUtil;

    @Autowired
    public AuthService(UserClientService userClientService, JwtService jwtUtil) {
        this.userClientService = userClientService;
        this.jwtUtil = jwtUtil;
    }

    public String register(AuthRequest authRequest) {
        authRequest.setPassword(BCrypt.hashpw(authRequest.getPassword(), BCrypt.gensalt()));
        userClientService.registerUser(authRequest);
        return "User registered successfully";
    }

    public String login(AuthRequest authRequest) {
        logger.info("Login request for user: " + authRequest);
        AuthRequest user = userClientService.loginUser(authRequest);
        if (user != null) {
            return jwtUtil.generateToken(user.getName(), user.getRole(), "ACCESS");
        } else {
            return "Invalid credentials";
        }
    }


}
