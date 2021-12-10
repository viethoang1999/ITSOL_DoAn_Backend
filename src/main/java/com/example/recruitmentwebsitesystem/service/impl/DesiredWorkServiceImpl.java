package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.Desiredwork;
import com.example.recruitmentwebsitesystem.repo.DesireWorkRepo;
import com.example.recruitmentwebsitesystem.service.DesireWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Optional;

@Service
public class DesiredWorkServiceImpl implements DesireWorkService {
    @Autowired
    private DesireWorkRepo desiredWorkRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public Desiredwork findById(Integer id) {
        try {
            if(id==null) {
                return null;
            }
            Optional<Desiredwork> optional = desiredWorkRepository.findById(id);
            if(optional.isPresent()) {
                return optional.get();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Integer findDesiredWorkIdByDesiredworkname(String desiredworkname) {
        try {
            String sql = "select id from desiredwork where trim(lower(desiredworkname)) = lower(:desiredworkname)";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("desiredworkname", desiredworkname);
            return (Integer) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
