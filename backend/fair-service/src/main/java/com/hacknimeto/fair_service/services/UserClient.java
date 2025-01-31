package com.hacknimeto.fair_service.services;

import com.hacknimeto.fair_service.entities.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/users/get/{id}")
    UserEntity getUserById(@PathVariable Long id);
}
