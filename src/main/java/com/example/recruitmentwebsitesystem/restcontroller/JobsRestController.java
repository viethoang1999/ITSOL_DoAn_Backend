package com.example.recruitmentwebsitesystem.restcontroller;
import com.example.recruitmentwebsitesystem.entity.Jobs;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import com.example.recruitmentwebsitesystem.generic.impl.GenericController;
import com.example.recruitmentwebsitesystem.service.impl.JobsImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin/jobs")
public class JobsRestController extends GenericController<Jobs, Integer> {

public JobsRestController(BaseService<Jobs, Integer> baseService) {

        super(baseService);
        }
    @Autowired
    private JobsImpl jobsImpl;
    @GetMapping("/all")
    public List<Jobs> getJobs()
    {
        return jobsImpl.getListAll();
    }
}
