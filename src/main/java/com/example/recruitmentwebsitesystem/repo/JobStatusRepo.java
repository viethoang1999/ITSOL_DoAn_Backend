package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.JobStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobStatusRepo extends JpaRepository<JobStatus, Integer> {
}
