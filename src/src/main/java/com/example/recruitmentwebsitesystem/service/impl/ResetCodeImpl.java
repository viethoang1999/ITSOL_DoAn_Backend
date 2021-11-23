package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.Notifications;
import com.example.recruitmentwebsitesystem.entity.ResetCode;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.service.NotificationsService;
import com.example.recruitmentwebsitesystem.service.ResetCodeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ResetCodeImpl extends GenericServiceImpl<ResetCode, Integer> implements ResetCodeService {

    public ResetCodeImpl(JpaRepository<ResetCode, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
