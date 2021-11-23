package com.example.recruitmentwebsitesystem.controller;

import com.example.recruitmentwebsitesystem.entity.Notifications;
import com.example.recruitmentwebsitesystem.entity.Permission;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import com.example.recruitmentwebsitesystem.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permission")
public class PermissionController extends GenericController<Permission, Integer> {

    public PermissionController(BaseService<Permission, Integer> baseService) {

        super(baseService);
    }
}
