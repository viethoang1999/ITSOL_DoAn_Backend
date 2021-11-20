//package com.example.recruitmentwebsitesystem.service.impl;
//
//import com.example.recruitmentwebsitesystem.entity.AcademicLevel;
//import com.example.recruitmentwebsitesystem.generic.impl.impl.impl.GenericServiceImpl;
//import com.example.recruitmentwebsitesystem.repo.UsersRepo;
//import com.example.recruitmentwebsitesystem.service.AcademicLevelService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailService implements U{
//
//    @Autowired
//    UserRepo userRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User account = this.userRepo.findByUsername(username);
//        if(account == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        else return new CustomUserDetail(account);
//    }
//}
//
//
