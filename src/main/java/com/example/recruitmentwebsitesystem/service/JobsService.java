package com.example.recruitmentwebsitesystem.service;

import com.example.recruitmentwebsitesystem.entity.Jobs;
import com.example.recruitmentwebsitesystem.generic.BaseService;

import java.util.List;

public interface JobsService extends BaseService<Jobs, Integer> {

    List<Jobs> getListAll();


//    Jobs findByID(Integer id);
//
//    Jobs save(Jobs companyEntity);
}
