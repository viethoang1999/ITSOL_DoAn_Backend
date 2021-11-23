package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.JobStatus;
import org.springframework.stereotype.Repository;

@Repository
public interface JobStatusRepo extends BaseRepo<JobStatus, Integer> {
}
