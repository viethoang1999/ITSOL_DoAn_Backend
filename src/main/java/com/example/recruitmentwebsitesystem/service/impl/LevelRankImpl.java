package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.LevelRank;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.service.LevelRankService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class LevelRankImpl  extends GenericServiceImpl<LevelRank, Integer> implements LevelRankService {

        public LevelRankImpl(JpaRepository<LevelRank, Integer> jpaRepository) {
                super(jpaRepository);
        }
}

