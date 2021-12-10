package com.example.recruitmentwebsitesystem.controller;

import com.example.recruitmentwebsitesystem.dto.ResponseDTO;
import com.example.recruitmentwebsitesystem.entity.Jobs;
import com.example.recruitmentwebsitesystem.entity.JobsRegister;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import com.example.recruitmentwebsitesystem.generic.impl.GenericController;
import com.example.recruitmentwebsitesystem.service.impl.JobRegisterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{$spring.data.rest.base-path}/jobsRegister")

public class JobsRegisterController {

    @Autowired
    private JobRegisterImpl jobRegisterImpl;

    @Autowired
    private ResponseDTO responseDTO;

    @GetMapping("/getAll")
    @CrossOrigin
    public ResponseEntity<ResponseDTO<List<JobsRegister>>> getAll() {
        responseDTO.setData(jobRegisterImpl.getAllJobsRegister());
        return new ResponseEntity<ResponseDTO<List<JobsRegister>>>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    @CrossOrigin
    public ResponseEntity<JobsRegister> getById(@PathVariable("id") int id) {
        return new ResponseEntity<>(jobRegisterImpl.getJobsRegister(id), HttpStatus.OK);
    }

}

