package com.example.recruitmentwebsitesystem.controller;

import com.example.recruitmentwebsitesystem.entity.AcademicLevel;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import com.example.recruitmentwebsitesystem.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/academicLevel")
public class AcademicLevelController extends GenericController<AcademicLevel, Integer> {

    public AcademicLevelController(BaseService<AcademicLevel, Integer> baseService) {

        super(baseService);
    }
}