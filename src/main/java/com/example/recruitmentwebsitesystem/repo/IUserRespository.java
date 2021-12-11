package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRespository extends JpaRepository<Users,Integer> {
    Users findByUserName(String userName);

    Users getUserById(Long id);
    @Query(value = "from Users u where u.fullName like %:fullName%")
    List<Users> findByFullName(@Param("fullName") String fullName);
}
