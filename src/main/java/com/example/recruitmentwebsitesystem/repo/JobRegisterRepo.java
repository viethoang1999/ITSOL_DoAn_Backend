package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.JobsRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRegisterRepo extends JpaRepository<JobsRegister, Integer> {
    List<JobsRegister> findAll();
}
