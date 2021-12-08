package com.example.recruitmentwebsitesystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.recruitmentwebsitesystem.entity.Jobs;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.repo.JobsRepo;
import com.example.recruitmentwebsitesystem.service.JobsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobsImpl extends GenericServiceImpl<Jobs, Integer> implements JobsService {
    @Autowired
    private JobsRepo jobsRepo;
    public JobsImpl(JpaRepository<Jobs, Integer> jpaRepository) {
        super(jpaRepository);
    }

    @Override
    public List<Jobs> getListAll(){

        return jobsRepo.findAll();
    }
}
