package com.example.recruitmentwebsitesystem.service;

import com.example.recruitmentwebsitesystem.entity.Desiredwork;
import org.springframework.stereotype.Component;
public interface DesireWorkService {
    Desiredwork findById(Integer id);
    Integer findDesiredWorkIdByDesiredworkname(String desiredworkname);
}
