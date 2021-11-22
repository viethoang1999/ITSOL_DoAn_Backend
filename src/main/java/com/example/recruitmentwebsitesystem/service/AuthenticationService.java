package com.example.recruitmentwebsitesystem.service;

import com.example.recruitmentwebsitesystem.entity.Users;
import com.example.recruitmentwebsitesystem.security.auth2.OAuth2UserInfo;

public interface AuthenticationService {
    Users findByResetOtpCode(String code);
    boolean sendPasswordResetCode(String email);
    String passwordReset(String email,String password);
    Users registerOauth2User(String provider, OAuth2UserInfo oAuth2UserInfo);

    Users updateOauth2User(Users user, String provider, OAuth2UserInfo oAuth2UserInfo);
}
