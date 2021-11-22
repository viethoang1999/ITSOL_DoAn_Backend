package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.ERole;
import com.example.recruitmentwebsitesystem.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends BaseRepo<Role, Integer> {
    Optional<Role> findByRole(ERole roleName);
}
