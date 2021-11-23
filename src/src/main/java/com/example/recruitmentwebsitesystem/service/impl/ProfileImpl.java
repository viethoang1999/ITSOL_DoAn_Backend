package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.Notifications;
import com.example.recruitmentwebsitesystem.entity.Profiles;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.service.NotificationsService;
import com.example.recruitmentwebsitesystem.service.ProfileService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileImpl extends GenericServiceImpl<Profiles, Integer> implements ProfileService {

    public ProfileImpl(JpaRepository<Profiles, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
