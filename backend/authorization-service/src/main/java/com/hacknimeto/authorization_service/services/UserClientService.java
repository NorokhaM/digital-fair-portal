package com.hacknimeto.authorization_service.services;

import com.hacknimeto.authorization_service.entities.AuthRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service")
public interface UserClientService {

    @PostMapping("/users/register")
    AuthRequest registerUser(@RequestBody AuthRequest user);

    @PostMapping("/users/login")
    AuthRequest loginUser(@RequestBody AuthRequest user);

}
