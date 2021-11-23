package com.example.recruitmentwebsitesystem.service.impl;


import com.example.recruitmentwebsitesystem.entity.Users;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.repo.UsersRepo;
import com.example.recruitmentwebsitesystem.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersImpl extends GenericServiceImpl<Users, Integer> implements UsersService {

    public UsersImpl(JpaRepository<Users, Integer> jpaRepository) {
        super(jpaRepository);
    }

    @Autowired
    UsersRepo userRepo;

//    @Override
//    public Users findUserByEmail(String email) {
//        return userRepo.findByEmail(email);
//    }
//
//    @Override
//    public Users findByName(String name) {
//        return userRepo.findByUsername(name);
//    }
//
//    @Override
//    public Users save(Users user) {
//        return userRepo.save(user);
//    }

//    @Override
//    public boolean existByUserName(String username) {
//        return userRepo.existsByUsername(username);
//    }
//
//    @Override
//    public boolean existByEmail(String email) {
//        return userRepo.existsByEmail(email);
//    }
}
