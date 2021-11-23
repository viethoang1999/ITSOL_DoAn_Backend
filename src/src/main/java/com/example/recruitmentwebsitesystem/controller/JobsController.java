package com.example.recruitmentwebsitesystem.controller;

import com.example.recruitmentwebsitesystem.entity.Jobs;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import com.example.recruitmentwebsitesystem.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobsController extends GenericController<Jobs, Integer> {

    public JobsController(BaseService<Jobs, Integer> baseService) {

        super(baseService);
    }
}
