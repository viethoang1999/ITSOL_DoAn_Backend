package com.example.recruitmentwebsitesystem.service.impl;

import com.example.recruitmentwebsitesystem.dto.InformationUserDTO;
import com.example.recruitmentwebsitesystem.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InformationService {

    @Autowired
    private UsersRepo usersRepo;

    public List<InformationUserDTO> getInforById(Integer userid) {
        List<InformationUserDTO> informationUserDTOList =  usersRepo.getInforbyId(userid);
        return informationUserDTOList;
    }
}
