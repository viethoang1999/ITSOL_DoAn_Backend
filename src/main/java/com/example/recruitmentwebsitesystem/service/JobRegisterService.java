package com.example.recruitmentwebsitesystem.service;

import com.example.recruitmentwebsitesystem.entity.JobsRegister;
import com.example.recruitmentwebsitesystem.generic.BaseService;

import java.util.List;

public interface JobRegisterService extends BaseService<JobsRegister, Integer> {
    List<JobsRegister> getAllJobsRegister();
}

