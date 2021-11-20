package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.JobsRegister;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.service.JobRegisterService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class JobRegisterImpl extends GenericServiceImpl<JobsRegister, Integer> implements JobRegisterService {

    public JobRegisterImpl(JpaRepository<JobsRegister, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
