package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.Jobs;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepo extends BaseRepo<Jobs, Integer> {
}
