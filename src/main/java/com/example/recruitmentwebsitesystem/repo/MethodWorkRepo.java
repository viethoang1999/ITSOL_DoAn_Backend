package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.MethodWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MethodWorkRepo extends JpaRepository <MethodWork,Integer> {
}
