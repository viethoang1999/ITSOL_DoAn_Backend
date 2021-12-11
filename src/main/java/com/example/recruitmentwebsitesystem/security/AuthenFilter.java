package com.example.recruitmentwebsitesystem.security;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.recruitmentwebsitesystem.dto.AuthenDTO;
import com.example.recruitmentwebsitesystem.entity.OTP;
import com.example.recruitmentwebsitesystem.service.UsersService;
import com.example.recruitmentwebsitesystem.service.UsersServices;
import com.example.recruitmentwebsitesystem.service.impl.UserServiceimpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpStatus.FORBIDDEN;
public class AuthenFilter extends UsernamePasswordAuthenticationFilter{
    private AuthenticationManager authenticationManager;
    @Autowired
    UsersServices appUserService;

    public AuthenFilter(AuthenticationManager authenticationManager, UserServiceimpl appUserService) {
        this.authenticationManager = authenticationManager;
        this.appUserService = appUserService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            AuthenDTO usernamePassword = new ObjectMapper().readValue(request.getInputStream(), AuthenDTO.class);
            UserDetails userDetails = appUserService.loadUserByUsername(usernamePassword.getUsername());
            if(!userDetails.isAccountNonLocked()){
                response.setHeader("error", "Account is not activated");
                com.example.recruitmentwebsitesystem.entity.Users user = appUserService.getUser(usernamePassword.getUsername());
//               com.itsol.recruit_managerment.model.User user1 = appUserService.getUser(usernamePassword.getUsername());
                OTP newOTP = appUserService.retrieveNewOTP(user);
                new ObjectMapper().writeValue(response.getOutputStream(), newOTP.getCode());
            }
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(usernamePassword.getUsername(), usernamePassword.getPassword());
            return authenticationManager.authenticate(authenticationToken);
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User userDetails = (User) authResult.getPrincipal();
        com.auth0.jwt.algorithms.Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        String token = JWT.create()
                .withSubject(userDetails.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 20 * 60 * 1000))
                .withClaim("roles", userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);
        Map<String, String> tokenObj = new HashMap<>();
        tokenObj.put("token", token);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), tokenObj);
    }
}
