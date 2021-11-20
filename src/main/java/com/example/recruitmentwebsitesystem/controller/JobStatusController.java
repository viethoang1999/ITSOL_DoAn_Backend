package com.example.recruitmentwebsitesystem.controller;

import com.example.recruitmentwebsitesystem.entity.JobStatus;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import com.example.recruitmentwebsitesystem.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobStatus")
public class JobStatusController extends GenericController<JobStatus, Integer> {

    public JobStatusController(BaseService<JobStatus, Integer> baseService) {

        super(baseService);
    }
}
