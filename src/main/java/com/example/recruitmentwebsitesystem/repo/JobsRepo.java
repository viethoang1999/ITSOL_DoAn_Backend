package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsRepo extends JpaRepository<Jobs, Integer> {
    List<Jobs> findAll();

    Jobs getUserById(Integer id);

    @Query(value = "select * from jobs WHERE CURRENT_DATE - create_date <=7",nativeQuery = true)

    List<Jobs> getTimeJob();

    @Query(value = "select * from jobs WHERE salary <=18000", nativeQuery = true)

    List<Jobs> getSalaryJob();
}
