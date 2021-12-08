package com.example.recruitmentwebsitesystem.controller;

import com.example.recruitmentwebsitesystem.dto.ResponseDTO;
import com.example.recruitmentwebsitesystem.entity.Jobs;
import com.example.recruitmentwebsitesystem.service.impl.JobsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jobs")
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
}
