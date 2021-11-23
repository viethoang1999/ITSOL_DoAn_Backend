package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.ProfileStatus;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.service.ProfileStatusService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileStatusImpl extends GenericServiceImpl<ProfileStatus, Integer> implements ProfileStatusService {

    public ProfileStatusImpl(JpaRepository<ProfileStatus, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
