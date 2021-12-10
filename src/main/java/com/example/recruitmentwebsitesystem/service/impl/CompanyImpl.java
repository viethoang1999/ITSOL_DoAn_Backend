package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.Company;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.repo.CompanyRepo;
import com.example.recruitmentwebsitesystem.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyImpl extends GenericServiceImpl<Company, Integer> implements CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    public CompanyImpl(JpaRepository<Company, Integer> jpaRepository) {
        super(jpaRepository);
    }


    @Override
    public List<Company> getListAll() {

        return companyRepo.findAll();
    }

    @Override
    public Company findByID(Integer id) {
        try {
            Optional<Company> optional = companyRepo.findById(id);
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
    public Company save(Company companyEntity) {
        try {
            return companyRepo.save(companyEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
