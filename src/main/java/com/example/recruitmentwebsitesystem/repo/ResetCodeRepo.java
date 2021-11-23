package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.ProfileStatus;
import com.example.recruitmentwebsitesystem.entity.ResetCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

@Repository
public interface ResetCodeRepo extends JpaRepository<ResetCode, Integer> {
}
