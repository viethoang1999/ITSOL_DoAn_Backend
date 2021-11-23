package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.Role;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.service.RoleService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleImpl extends GenericServiceImpl<Role, Integer> implements RoleService {

    public RoleImpl(JpaRepository<Role, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
