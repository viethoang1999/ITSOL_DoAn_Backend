package com.example.recruitmentwebsitesystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

public interface BaseRepo <T, ID> extends JpaRepository<T, ID> {

}
