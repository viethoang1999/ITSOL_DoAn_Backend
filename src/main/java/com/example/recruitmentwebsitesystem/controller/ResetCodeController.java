package com.example.recruitmentwebsitesystem.controller;

import com.example.recruitmentwebsitesystem.entity.OTP;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import com.example.recruitmentwebsitesystem.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restCode")
public class ResetCodeController extends GenericController<OTP, Integer> {

    public ResetCodeController(BaseService<OTP, Integer> baseService) {

        super(baseService);
    }
}
