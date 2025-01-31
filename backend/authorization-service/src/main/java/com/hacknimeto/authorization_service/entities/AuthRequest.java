package com.hacknimeto.authorization_service.entities;

import lombok.Data;

@Data
public class AuthRequest {
    private String name;
    private String password;
    private String email;
    private String role;
}
