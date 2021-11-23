package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {
//    Users findByUsername(String user_name);
//
//    Boolean existsByUsername(String username);
//
//    Boolean existsByEmail(String email);
//
//    Users findByOtpCode(String code);
//
//    Users findByEmail(String email);
}
