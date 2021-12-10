package com.example.recruitmentwebsitesystem.service.impl;


import com.example.recruitmentwebsitesystem.entity.Users;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.repo.UsersRepo;
import com.example.recruitmentwebsitesystem.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersImpl implements UsersService {
    @Autowired
    private UsersRepo userRepository;
    @Override
    public List<Users> findAll() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Users save(Users userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public Users findByID(Integer id) {
        try {
            Optional<Users> optional = userRepository.findById(id);
            if(optional.isPresent()) {
                return optional.get();
            }
            return null;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }

    }
}


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

