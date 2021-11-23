package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.AcademicLevel;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.service.AcademicLevelService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AcademicLevelImpl extends GenericServiceImpl<AcademicLevel, Integer> implements AcademicLevelService {

    public AcademicLevelImpl(JpaRepository<AcademicLevel, Integer> jpaRepository) {
        super(jpaRepository);
    }
}