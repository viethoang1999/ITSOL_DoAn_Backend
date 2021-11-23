package com.example.recruitmentwebsitesystem.controller;

import com.example.recruitmentwebsitesystem.entity.ProfileStatus;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import com.example.recruitmentwebsitesystem.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profileStatus")
public class ProfileStatusController extends GenericController<ProfileStatus, Integer> {

    public ProfileStatusController(BaseService<ProfileStatus, Integer> baseService) {

        super(baseService);
    }
}
