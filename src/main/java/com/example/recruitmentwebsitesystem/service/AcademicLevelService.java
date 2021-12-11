package com.example.recruitmentwebsitesystem.service;

import com.example.recruitmentwebsitesystem.entity.AcademicLevel;
import com.example.recruitmentwebsitesystem.generic.BaseService;

public interface AcademicLevelService  extends BaseService<AcademicLevel, Integer> {
    AcademicLevel findById(Integer id);

    Integer findAcademic_nameById(String academicName);
}
