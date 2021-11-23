package com.example.recruitmentwebsitesystem.controller;

import com.example.recruitmentwebsitesystem.entity.LevelRank;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import com.example.recruitmentwebsitesystem.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/levelRank")
public class LevelRankController extends GenericController<LevelRank, Integer> {

    public LevelRankController(BaseService<LevelRank, Integer> baseService) {

        super(baseService);
    }
}
