package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.JobsRegister;
import com.example.recruitmentwebsitesystem.repo.JobRegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobRegisterImpl {

    @Autowired
    JobRegisterRepo jobRegisterRepo;

    public List<JobsRegister> getAllJobsRegister() {
        return jobRegisterRepo.findAll();
    }

    public JobsRegister getJobsRegister(int id){
        return jobRegisterRepo.findById(id);
    }
}
