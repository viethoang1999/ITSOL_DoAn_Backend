package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.entity.Notifications;
import com.example.recruitmentwebsitesystem.entity.Profiles;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.repo.ProfileRepo;
import com.example.recruitmentwebsitesystem.repo.ProfileStatusRepo;
import com.example.recruitmentwebsitesystem.service.NotificationsService;
import com.example.recruitmentwebsitesystem.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileImpl  implements ProfileService {

    @Autowired
    private ProfileRepo profileRepository;

    @Override
    public List<Profiles> findAll() {
        try {
            return profileRepository.findAll();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Page<Profiles> findPage(int page, int size) {
        return null;
    }

    @Override
    public Profiles findById(Integer integer) {
        return null;
    }

    @Override
    public Profiles create(Profiles obj) {
        return null;
    }

    @Override
    public Profiles update(Profiles obj) {
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
    public Profiles save(Profiles profileEntity) {
        return profileRepository.save(profileEntity);
    }

    @Override
    public Profiles findByID(Integer id) {
        try {
            Optional<Profiles> optional = profileRepository.findById(id);
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
}
