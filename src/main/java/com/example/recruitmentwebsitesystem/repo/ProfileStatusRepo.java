package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.ProfileStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileStatusRepo extends JpaRepository<ProfileStatus,Integer> {
}
