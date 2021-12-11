package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.AcademicLevel;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.repo.AcademicLevelRepo;
import com.example.recruitmentwebsitesystem.service.AcademicLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;



@Service
public class AcademicLevelImpl implements AcademicLevelService {

    @Autowired
    private AcademicLevelRepo academic_levelRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<AcademicLevel> findAll() {
        return null;
    }

    @Override
    public Page<AcademicLevel> findPage(int page, int size) {
        return null;
    }

    @Override
    public AcademicLevel findById(Integer id) {
        try {
            if(id==null) {
                return null;
            }
            Optional<AcademicLevel> optional = academic_levelRepository.findById(id);
            if(optional.isPresent()) {
                return optional.get();
            }
            return null;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public AcademicLevel create(AcademicLevel obj) {
        return null;
    }

    @Override
    public AcademicLevel update(AcademicLevel obj) {
        return null;
    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Integer findAcademic_nameById(String academic_name) {
        try {
            String sql = "select id from academic_level where trim(lower(academic_name)) = lower(:academic_name)";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("academic_name", academic_name);
            return (Integer) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}