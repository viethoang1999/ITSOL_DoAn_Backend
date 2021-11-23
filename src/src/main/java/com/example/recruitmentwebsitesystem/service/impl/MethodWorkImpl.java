package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.MethodWork;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.service.MethodWorkService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MethodWorkImpl extends GenericServiceImpl<MethodWork, Integer> implements MethodWorkService {

    public MethodWorkImpl(JpaRepository<MethodWork, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
