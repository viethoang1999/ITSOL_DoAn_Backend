package com.example.recruitmentwebsitesystem.controller;

import com.example.recruitmentwebsitesystem.entity.Types;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import com.example.recruitmentwebsitesystem.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/types")
public class TypesController extends GenericController<Types, Integer> {

    public TypesController(BaseService<Types, Integer> baseService) {

        super(baseService);
    }
}
