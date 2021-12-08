package com.example.recruitmentwebsitesystem.service.impl;
import com.example.recruitmentwebsitesystem.dto.CustomUserDetail;
import com.example.recruitmentwebsitesystem.entity.Users;
import com.example.recruitmentwebsitesystem.repo.UsersRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepo.findByUserName(username);
        if (users==null){
            return (UserDetails) new UsernameNotFoundException("User Not Found with username: " + username);
        }
//        User user = userRepo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User Not Found with username: " + username));
        return CustomUserDetail.build(users);
    }

}
