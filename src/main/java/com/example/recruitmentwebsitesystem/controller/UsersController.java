package com.example.recruitmentwebsitesystem.controller;

import com.example.recruitmentwebsitesystem.entity.User;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import com.example.recruitmentwebsitesystem.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController extends GenericController<User, Integer> {

    public UsersController(BaseService<User, Integer> baseService) {

        super(baseService);
    }
}
