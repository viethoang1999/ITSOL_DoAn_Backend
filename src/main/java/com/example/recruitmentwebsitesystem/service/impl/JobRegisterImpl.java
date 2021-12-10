package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.JobsRegister;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.repo.JobRegisterRepo;
import com.example.recruitmentwebsitesystem.service.JobRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobRegisterImpl extends GenericServiceImpl<JobsRegister, Integer> implements JobRegisterService {
    @Autowired
    final JobRegisterRepo jobRegisterRepo;



    public JobsRegister getJobsRegister(int id){
        return jobRegisterRepo.findById(id);
    }
    public JobRegisterImpl(JpaRepository<JobsRegister, Integer> jpaRepository, JobRegisterRepo jobRegisterRepo) {
        super(jpaRepository);
        this.jobRegisterRepo = jobRegisterRepo;
    }

    @Override
    public List<JobsRegister> getAllJobsRegister() {
        return jobRegisterRepo.findAll();
    }



}
