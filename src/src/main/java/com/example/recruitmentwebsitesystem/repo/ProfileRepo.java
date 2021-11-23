package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.ProfileStatus;
import com.example.recruitmentwebsitesystem.entity.Profiles;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends BaseRepo<Profiles, Integer> {
}
