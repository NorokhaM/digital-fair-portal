package com.hacknimeto.fair_service.entities;

import jakarta.persistence.*;
import lombok.Data;


@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;


}
