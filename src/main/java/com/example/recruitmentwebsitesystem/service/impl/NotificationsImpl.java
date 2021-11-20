package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.Notifications;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.service.NotificationsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationsImpl extends GenericServiceImpl<Notifications, Integer> implements NotificationsService {

    public NotificationsImpl(JpaRepository<Notifications, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
