package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.Jobs;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.repo.JobsRepo;
import com.example.recruitmentwebsitesystem.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobsImpl extends GenericServiceImpl<Jobs, Integer> implements JobsService {

    @Autowired
    JobsRepo jobsRepo;

    public JobsImpl(JpaRepository<Jobs, Integer> jpaRepository) {
        super(jpaRepository);
    }

    public List<Jobs> getAllJobs(){
        return  jobsRepo.findAll();
    }


    public Jobs getJob(int id){
        return jobsRepo.findById(id).get();
    }

    public List<Jobs> getTimeJobs(){

        return jobsRepo.getTimeJob();
    }
    public  List<Jobs> getSalaryJobs(){
        return  jobsRepo.getSalaryJob();
    }




}
