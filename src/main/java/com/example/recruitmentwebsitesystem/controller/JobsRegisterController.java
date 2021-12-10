package com.example.recruitmentwebsitesystem.controller;

import com.example.recruitmentwebsitesystem.dto.ResponseDTO;
import com.example.recruitmentwebsitesystem.entity.JobsRegister;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import com.example.recruitmentwebsitesystem.generic.impl.GenericController;
import com.example.recruitmentwebsitesystem.service.JobRegisterService;
import com.example.recruitmentwebsitesystem.service.impl.JobRegisterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobsRegister")
public class JobsRegisterController extends GenericController<JobsRegister, Integer> {
    @Autowired
    private JobRegisterImpl jobRegisterImpl;

    @Autowired
    private ResponseDTO responseDTO;

    final JobRegisterService jobRegisterService;

    public JobsRegisterController(BaseService<JobsRegister, Integer> baseService, JobRegisterService jobRegisterService) {
        super(baseService);
        this.jobRegisterService = jobRegisterService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO<List<JobsRegister>>> getAll (
    ) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(jobRegisterService.getAllJobsRegister());
        return new ResponseEntity<ResponseDTO<List<JobsRegister>>>(responseDTO, HttpStatus.OK);
    }


//    @GetMapping("/getAll")
//    @CrossOrigin
//    public ResponseEntity<ResponseDTO<List<JobsRegister>>> getAll() {
//        responseDTO.setData(jobRegisterImpl.getAllJobsRegister());
//        return new ResponseEntity<ResponseDTO<List<JobsRegister>>>(responseDTO, HttpStatus.OK);
//    }

    @GetMapping("/getById/{id}")
    @CrossOrigin
    public ResponseEntity<JobsRegister> getById(@PathVariable("id") int id) {
        return new ResponseEntity<>(jobRegisterImpl.getJobsRegister(id), HttpStatus.OK);
    }
}

