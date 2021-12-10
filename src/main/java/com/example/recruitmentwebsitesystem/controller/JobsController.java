package com.example.recruitmentwebsitesystem.controller;

import com.example.recruitmentwebsitesystem.dto.ResponseDTO;
import com.example.recruitmentwebsitesystem.entity.Jobs;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import com.example.recruitmentwebsitesystem.service.impl.JobsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@CrossOrigin("*")
public class JobsController {
    @Autowired
    private JobsImpl jobsImpl;
    @Autowired
    private ResponseDTO responseDTO;


    //    public JobsController(BaseService<Jobs, Integer> baseService) {
//
//        super(baseService);
//    }
    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO<List<Jobs>>> getAll() {
        responseDTO.setData(jobsImpl.getAllJobs());
        return new ResponseEntity<ResponseDTO<List<Jobs>>>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/getJob/{id}")
    public ResponseEntity<Jobs> getJob(@PathVariable("id") int id) {
//        responseDTO.setData(jobsImpl.findById(id));
//       responseDTO.getData(jobsImpl.getJob());
        Jobs jobs = jobsImpl.getJob(id);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/getTimeJobs")

    public ResponseEntity<ResponseDTO<List<Jobs>>> getTimeJob() {
        responseDTO.setData(jobsImpl.getTimeJobs());
        return new ResponseEntity<ResponseDTO<List<Jobs>>>(responseDTO, HttpStatus.OK);

    }


    @GetMapping("/getSalaryJob")

    public ResponseEntity<ResponseDTO<List<Jobs>>> getSalaryJob(){
        responseDTO.setData(jobsImpl.getSalaryJobs());
        return new ResponseEntity<ResponseDTO<List<Jobs>>>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/home-page/{page}/{size}")
    public List<Jobs> getListJobWithConditions(
            @RequestParam("modjob") Integer modJob
            , @PathVariable("page") Integer page
            , @PathVariable("size") Integer size) {
        // get job mowis tuyen
        if (modJob == 0) {
            Integer nunberDate = 7;
            return jobsImpl.getListNewJobs(page, size);
        } else if (modJob == 1) {
            // get job luong cao
            Integer salary = 18000000;
            return jobsImpl.getListJobSalary(page, size);
        } else if (modJob == 2) {
            // get job deadline
            Integer deadLine = 3;
            return jobsImpl.getListJobDeadline(deadLine, page, size);
        } else {
            return null;
        }

    }

}
