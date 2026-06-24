package com.example.BloodLink.entity;


import com.example.BloodLink.enums.*;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Data
public class User {
    @Id//this tell JPA hibernate that this userId variable is the primary key sort of
    @GeneratedValue(strategy= GenerationType.IDENTITY)//this is like autoincrement in sql-objects datatype
//    GenerationType.IDENTITY will tell hibernate that let mysqls autoincrement handle ID generation
    private Integer userId;
    private String fullName;
    private String email;
    private String passHash;
    private String phoneNumber;
    private String city;
    private String state;
    private String bloodGroup;

    @Enumerated(EnumType.STRING)//it means store the enum as a STRING rather than in numbers
    private Role role;

    private LocalDateTime createdAt;
}
