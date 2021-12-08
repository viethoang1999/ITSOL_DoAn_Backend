package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.Permission;
import com.example.recruitmentwebsitesystem.entity.ProfileStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepo extends JpaRepository<Permission,Integer> {
    @Query("SELECT entity FROM Permission entity WHERE user_id=:user_id and role_id=:role_id")
    public Permission isExist(@Param("user_id") Integer userId, @Param("role_id") Integer roleId);
}
