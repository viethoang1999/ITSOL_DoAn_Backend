package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.OTP;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.service.ResetCodeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ResetCodeImpl extends GenericServiceImpl<OTP, Integer> implements ResetCodeService {

    public ResetCodeImpl(JpaRepository<OTP, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
