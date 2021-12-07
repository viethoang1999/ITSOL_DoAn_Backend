package com.example.recruitmentwebsitesystem.service;

import com.example.recruitmentwebsitesystem.entity.Users;
import com.example.recruitmentwebsitesystem.generic.BaseService;

import java.util.List;

public interface UsersService extends BaseService<Users, Integer> {
//    Users findUserByEmail(String email);
//    Users findByName(String name);
//    Users save(Users user);
//    boolean existByUserName(String username);
//    boolean existByEmail(String email);
    List<Users> findAll();

    Users save(Users userEntity);

    Users findByID(Integer id);
}

