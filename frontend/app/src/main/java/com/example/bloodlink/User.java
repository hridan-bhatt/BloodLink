package com.example.bloodlink;

public class User {
    private String fullName;
    private String email;
    private String phone;
    private String bloodGroup;
    private String city;
    private String state;
    private String role;

    public User(String fullName,String email,String phone,String bloodGroup,String city,String state, String role){
        this.fullName=fullName;
        this.city=city;
        this.email=email;
        this.phone=phone;
        this.bloodGroup=bloodGroup;
        this.role=role;
        this.state=state;
    }
    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getRole() {
        return role;
    }
}
