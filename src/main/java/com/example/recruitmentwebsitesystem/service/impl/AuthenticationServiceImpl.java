//package com.example.recruitmentwebsitesystem.service.impl;
//
//import com.example.recruitmentwebsitesystem.entity.ERole;
//import com.example.recruitmentwebsitesystem.entity.Role;
//import com.example.recruitmentwebsitesystem.entity.Users;
//import com.example.recruitmentwebsitesystem.jwt.JwtHelper;
//import com.example.recruitmentwebsitesystem.repo.RoleRepo;
//import com.example.recruitmentwebsitesystem.repo.UsersRepo;
//import com.example.recruitmentwebsitesystem.security.auth2.OAuth2UserInfo;
//import com.example.recruitmentwebsitesystem.service.AuthenticationService;
//import lombok.RequiredArgsConstructor;
//import lombok.SneakyThrows;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//@Service
//@RequiredArgsConstructor
//public class AuthenticationServiceImpl implements AuthenticationService {
//    private final PasswordEncoder encoder;
//    private final JwtHelper jwtHelper;
//
//    private final UsersRepo userRepo;
//    private final RoleRepo roleRepo;
//
//
//    @Value("${hostname}")
//    private String hostname;
//
//    @Override
//    public Users findByResetOtpCode(String code) {
//        return userRepo.findByOtpCode(code);
//    }
//
//    @SneakyThrows
//    @Override
//    public boolean sendPasswordResetCode(String email) {
//        Users user = userRepo.findByEmail(email);
//        if (user == null) return false;
//
//        userRepo.save(user);
//
//        String subject = "Password reset";
//        String template = "password-reset";
//        Map<String, Object> attributes = new HashMap<>();
//        attributes.put("firstName", user.getFullName());
//
//        return true;
//    }
//
//    @Override
//    public String passwordReset(String email, String password) {
//        Users user = userRepo.findByEmail(email);
//        user.setPassWord(encoder.encode(password));
//
//        userRepo.save(user);
//        return "Password successfully changed!";
//    }
//
//    @Override
//    public Users registerOauth2User(String provider, OAuth2UserInfo oAuth2UserInfo) {
//        Role userRole = roleRepo.findByRole(ERole.USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//        Set<Role> roles = new HashSet<>();
//        roles.add(userRole);
//
//        Users user = new Users();
//        user.setEmail(oAuth2UserInfo.getEmail());
//        user.setPassWord(Long.toHexString(System.currentTimeMillis()));
//        user.setUserName(oAuth2UserInfo.getLastName());
//        user.setFullName(oAuth2UserInfo.getFirstName() + oAuth2UserInfo.getLastName());
//        user.setUserStatus(1);
//        user.setRoles(roles);
//
//        return userRepo.save(user);
//    }
//
//    @Override
//    public Users updateOauth2User(Users user, String provider, OAuth2UserInfo oAuth2UserInfo) {
//        return null;
//    }
//}
