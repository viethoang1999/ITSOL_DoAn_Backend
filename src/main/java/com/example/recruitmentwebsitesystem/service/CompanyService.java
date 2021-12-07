package com.example.recruitmentwebsitesystem.service;

import com.example.recruitmentwebsitesystem.entity.Company;
import com.example.recruitmentwebsitesystem.generic.BaseService;

import java.util.List;

public interface CompanyService extends BaseService<Company, Integer> {

        List<Company> getListAll();

        Company findByID(Integer id);

        Company save(Company companyEntity);
        }

