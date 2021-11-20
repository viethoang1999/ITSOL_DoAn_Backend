package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.Notifications;
import com.example.recruitmentwebsitesystem.entity.Permission;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.service.NotificationsService;
import com.example.recruitmentwebsitesystem.service.PermissionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PermissionImpl extends GenericServiceImpl<Permission, Integer> implements PermissionService {

    public PermissionImpl(JpaRepository<Permission, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
