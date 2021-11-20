package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.Types;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.service.TypesService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TypesImpl extends GenericServiceImpl<Types, Integer> implements TypesService {

    public TypesImpl(JpaRepository<Types, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
