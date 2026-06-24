package com.example.BloodLink.service;


import com.example.BloodLink.dto.SignUpRequest;
import com.example.BloodLink.entity.User;
import com.example.BloodLink.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public void signup(SignUpRequest signupObj){
        System.out.println(signupObj);
        boolean emailExists=userRepository.existsByEmail(signupObj.getEmail());
        if(emailExists){
            throw new RuntimeException("Email already Registered");
        }
        User user=new User();
        user.setFullName(signupObj.getFullName());
        user.setEmail(signupObj.getEmail());
        user.setCity(signupObj.getCity());
        user.setPhoneNumber(signupObj.getPhoneNumber());
        user.setRole(signupObj.getRole());
        user.setState(signupObj.getState());
        user.setBloodGroup(signupObj.getBloodGroup());
        user.setPassHash(signupObj.getPassword());
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
    }


}
