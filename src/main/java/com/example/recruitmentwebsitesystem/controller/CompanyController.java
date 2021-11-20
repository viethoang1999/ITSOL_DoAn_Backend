package com.example.recruitmentwebsitesystem.controller;

import com.example.recruitmentwebsitesystem.entity.Company;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import com.example.recruitmentwebsitesystem.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController extends GenericController<Company, Integer> {

    public CompanyController(BaseService<Company, Integer> baseService) {

        super(baseService);
    }
}
