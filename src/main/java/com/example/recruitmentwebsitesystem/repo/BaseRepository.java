package com.example.recruitmentwebsitesystem.repo;

import lombok.Getter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Getter
@Repository
public class BaseRepository {

    @PersistenceContext
    EntityManager entityManager;

}
