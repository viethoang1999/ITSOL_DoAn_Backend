package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.AcademicLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicLevelRepo extends JpaRepository<AcademicLevel, Integer> {
}
