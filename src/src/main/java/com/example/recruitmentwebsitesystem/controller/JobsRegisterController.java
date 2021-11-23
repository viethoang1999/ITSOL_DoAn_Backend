package com.example.recruitmentwebsitesystem.controller;

import com.example.recruitmentwebsitesystem.entity.JobsRegister;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import com.example.recruitmentwebsitesystem.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobsRegister")
public class JobsRegisterController extends GenericController<JobsRegister, Integer> {

    public JobsRegisterController(BaseService<JobsRegister, Integer> baseService) {

        super(baseService);
    }
        }

