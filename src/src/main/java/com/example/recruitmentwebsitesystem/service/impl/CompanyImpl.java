package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.Company;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.service.CompanyService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyImpl extends GenericServiceImpl<Company, Integer> implements CompanyService {

    public CompanyImpl(JpaRepository<Company, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
