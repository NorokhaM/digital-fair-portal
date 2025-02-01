package com.hacknimeto.fair_service.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hacknimeto.fair_service.enums.Type;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Fair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column
    private String name;

    @Column
    private String description;


    @Column(name = "user_id")
    private Long userId;

    @Transient
    @JsonIgnore
    private UserEntity user;

}
