package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.Users;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.service.UsersService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersImpl extends GenericServiceImpl<Users, Integer> implements UsersService {

    public UsersImpl(JpaRepository<Users, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
