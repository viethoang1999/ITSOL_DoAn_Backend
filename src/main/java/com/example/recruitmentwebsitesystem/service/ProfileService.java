package com.example.recruitmentwebsitesystem.service;

import com.example.recruitmentwebsitesystem.entity.Notifications;
import com.example.recruitmentwebsitesystem.entity.Profiles;
import com.example.recruitmentwebsitesystem.generic.BaseService;

import java.util.List;

public interface ProfileService extends BaseService<Profiles, Integer> {
    List<Profiles> findAll();

    Profiles save(Profiles profileEntity);

    Profiles findByID(Integer id);
}
