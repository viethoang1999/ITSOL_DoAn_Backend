package com.example.recruitmentwebsitesystem.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.example.recruitmentwebsitesystem.dto.PassWordDTO;
import com.example.recruitmentwebsitesystem.entity.OTP;
import com.example.recruitmentwebsitesystem.entity.Role;
import com.example.recruitmentwebsitesystem.entity.Users;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
public interface UsersServices extends UserDetailsService {
    Users saveUser(Users user);

    Role saveRole(Role role);

    OTP saveOTP(OTP otp);

    void addRoleToUser(String username, String roleName);

    Users getUser(String username);

    Users getUserById(Long id);

    List<Users> getAllUsers();

    OTP generateOTP(Users user);

    OTP getOTPByUser(Users user);

    void verifyOTP(OTP otp, String otpCode);

    OTP retrieveNewOTP(Users user);

    void activeAccount(Users user);

    boolean verifyPassword(Users user, PassWordDTO passwordDTO);

    void changePassword(String password, Users user);

    Users loadUserFromContext();

//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return null;
//    }
}
