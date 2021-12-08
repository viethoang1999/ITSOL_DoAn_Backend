package com.example.recruitmentwebsitesystem.controller;
//
//import com.example.recruitmentwebsitesystem.dto.ResponseDTO;
import com.example.recruitmentwebsitesystem.entity.JobsRegister;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import com.example.recruitmentwebsitesystem.generic.impl.GenericController;
import com.example.recruitmentwebsitesystem.service.JobRegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jobsRegister")
public class JobsRegisterController extends GenericController<JobsRegister, Integer> {

    final JobRegisterService jobRegisterService;

    public JobsRegisterController(BaseService<JobsRegister, Integer> baseService, JobRegisterService jobRegisterService) {
        super(baseService);
        this.jobRegisterService = jobRegisterService;
    }

//    @GetMapping("/getAll")
//    public ResponseEntity<ResponseDTO<List<JobsRegister>>> getAll (
//    ) {
//        ResponseDTO responseDTO = new ResponseDTO();
//        responseDTO.setData(jobRegisterService.getAllJobsRegister());
//        return new ResponseEntity<ResponseDTO<List<JobsRegister>>>(responseDTO, HttpStatus.OK);
//    }

}

