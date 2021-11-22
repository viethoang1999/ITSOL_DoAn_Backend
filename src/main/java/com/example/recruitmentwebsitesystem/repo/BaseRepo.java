package com.example.recruitmentwebsitesystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepo <T, ID> extends JpaRepository<T, ID> {

}
