package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {
    Users findByUserName(String username);
    boolean existsByUserName(String username);
    boolean existsByEmail(String email);


}
