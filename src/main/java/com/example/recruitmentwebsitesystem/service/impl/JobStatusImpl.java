package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.JobStatus;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.service.JobStatusService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class JobStatusImpl extends GenericServiceImpl<JobStatus, Integer> implements JobStatusService {

    public JobStatusImpl(JpaRepository<JobStatus, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
