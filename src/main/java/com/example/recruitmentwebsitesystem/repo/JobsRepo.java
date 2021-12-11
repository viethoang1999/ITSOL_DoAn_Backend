package com.example.recruitmentwebsitesystem.repo;
import com.example.recruitmentwebsitesystem.entity.Jobs;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.recruitmentwebsitesystem.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsRepo extends JpaRepository<Jobs, Integer> {
    @Query(value = "select * from jobs WHERE " +
            "CURRENT_DATE - create_date <=7", nativeQuery = true)
    List<Jobs> getTimeJob();


    @Query(value = "select * from jobs WHERE salary >=18000", nativeQuery = true)
    List<Jobs> getSalaryJob();


    @Query(value = "select * from jobs WHERE CURRENT_DATE - create_date <=7", nativeQuery = true)
    List<Jobs> getListNewJob(Pageable pageable);

    @Query(value = "select * from jobs WHERE maxsalary >=18000", nativeQuery = true)
    List<Jobs> getListJobSalary(Pageable pageable);

    @Query(value = "select jobs.*,temp.countJob as datuyen  from jobs inner join  " +
            "        (select jobs.id, count(jobs.id) as countJob from jobs  " +
            "       inner join jobs_register on jobs.id  = jobs_register.job_id  + " +
            "        where jobs_register.profile_status_id =7 and jobs_register.is_delete =0 and jobs.is_delete = 0  + " +
            "        group by jobs.id ) temp on temp.id = jobs.id where temp.countJob < jobs.quantity_person  or  jobs.due_date - current_date  >= :numberDay", nativeQuery = true)
    List<Jobs> getListJobDeadline(@Param("numberDay") Integer numberDate, Pageable pageable);
}
