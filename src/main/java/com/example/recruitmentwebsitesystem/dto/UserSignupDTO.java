package com.example.recruitmentwebsitesystem.dto;

import com.example.recruitmentwebsitesystem.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSignupDTO {
    private String  fullName;
    private String  email;
    private String userName;
    private String password;
    private String  phoneNumber;
    private String  homeTown;
    private String  gender;
    private String birthDay;
    private Set<Role> roles;
}
