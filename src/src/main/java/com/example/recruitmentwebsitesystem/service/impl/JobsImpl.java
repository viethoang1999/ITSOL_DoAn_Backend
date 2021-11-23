package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.Jobs;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.service.JobsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class JobsImpl extends GenericServiceImpl<Jobs, Integer> implements JobsService {

    public JobsImpl(JpaRepository<Jobs, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
