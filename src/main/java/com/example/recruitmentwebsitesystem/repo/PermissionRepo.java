package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.Permission;
import com.example.recruitmentwebsitesystem.entity.ProfileStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepo extends JpaRepository<Permission,Integer> {
}
