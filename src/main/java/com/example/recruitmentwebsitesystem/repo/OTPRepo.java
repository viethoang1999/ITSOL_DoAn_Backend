package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.OTP;
import com.example.recruitmentwebsitesystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OTPRepo extends JpaRepository<OTP, Integer> {
    @Query("FROM OTP o WHERE o.user = :user")
    Optional<OTP> findByUser(@Param("user") Users user);
}
