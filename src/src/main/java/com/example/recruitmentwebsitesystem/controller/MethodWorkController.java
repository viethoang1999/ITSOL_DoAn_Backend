package com.example.recruitmentwebsitesystem.controller;

import com.example.recruitmentwebsitesystem.entity.MethodWork;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import com.example.recruitmentwebsitesystem.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/methodWork")
public class MethodWorkController extends GenericController<MethodWork, Integer> {

    public MethodWorkController(BaseService<MethodWork, Integer> baseService) {

        super(baseService);
    }
}
