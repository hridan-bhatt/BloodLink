package com.example.BloodLink.controller;


import com.example.BloodLink.dto.SignUpRequest;
import com.example.BloodLink.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/signup")
    public void signup(@RequestBody SignUpRequest signupobj){
        userService.signup(signupobj);
    }
}
