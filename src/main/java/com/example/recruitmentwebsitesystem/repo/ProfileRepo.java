package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.ProfileStatus;
import com.example.recruitmentwebsitesystem.entity.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepo extends JpaRepository<Profiles,Integer> {

}
