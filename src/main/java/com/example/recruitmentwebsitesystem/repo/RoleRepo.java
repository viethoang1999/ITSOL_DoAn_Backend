package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.ERole;
import com.example.recruitmentwebsitesystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    Optional<Role> findByRole(ERole roleName);
}
