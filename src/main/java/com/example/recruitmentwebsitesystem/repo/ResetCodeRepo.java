package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResetCodeRepo extends JpaRepository<OTP, Integer> {
}
