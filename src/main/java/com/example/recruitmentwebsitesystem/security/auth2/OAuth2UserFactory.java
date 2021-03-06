//package com.example.recruitmentwebsitesystem.security.auth2;
//
//import com.example.recruitmentwebsitesystem.entity.AuthProvider;
//import lombok.SneakyThrows;
//
//import javax.naming.AuthenticationException;
//import java.util.Map;
//
//public class OAuth2UserFactory {
//    @SneakyThrows
//    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
//        if(registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
//            return new Googl(attributes);
//        } else if (registrationId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
//            return new FacebookOAuth2UserInfo(attributes);
//        } else {
//            throw new AuthenticationException();
//        }
//    }
//}
