package com.example.BloodLink.dto;

import com.example.BloodLink.enums.Role;
import lombok.Data;

@Data
public class SignUpRequest {

    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;
    private String bloodGroup;
    private String city;
    private String state;
}
