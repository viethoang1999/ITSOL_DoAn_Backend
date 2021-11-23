package com.example.recruitmentwebsitesystem.controller;

import com.example.recruitmentwebsitesystem.entity.ResetCode;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import com.example.recruitmentwebsitesystem.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restCode")
public class ResetCodeController extends GenericController<ResetCode, Integer> {

    public ResetCodeController(BaseService<ResetCode, Integer> baseService) {

        super(baseService);
    }
}
