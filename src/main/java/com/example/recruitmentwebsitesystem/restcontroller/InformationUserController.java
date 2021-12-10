package com.example.recruitmentwebsitesystem.restcontroller;

import com.example.recruitmentwebsitesystem.dto.InfomationDTO;
import com.example.recruitmentwebsitesystem.entity.AcademicLevel;
import com.example.recruitmentwebsitesystem.entity.Desiredwork;
import com.example.recruitmentwebsitesystem.entity.Profiles;
import com.example.recruitmentwebsitesystem.entity.Users;
import com.example.recruitmentwebsitesystem.generic.impl.GenericResponse;
import com.example.recruitmentwebsitesystem.service.AcademicLevelService;
import com.example.recruitmentwebsitesystem.service.DesireWorkService;
import com.example.recruitmentwebsitesystem.service.ProfileService;
import com.example.recruitmentwebsitesystem.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class InformationUserController {


    @Autowired
    private DesireWorkService desiredWorkService;

    @Autowired
    private UsersService userService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private AcademicLevelService academic_levelService;


    @GetMapping("/getInformationUserById/{id}")
    public ResponseEntity<?> getInformationUserById(@PathVariable("id") Integer id){
        try {
            Profiles profileEntity = profileService.findByID(id);

            Users userEntity = userService.findByID(profileEntity.getUsers().getId());
            AcademicLevel academic_levelEntity = academic_levelService.findById(profileEntity.getAcademicLevel().getId());
            Desiredwork desiredWorkEntity = desiredWorkService.findById(profileEntity.getDesiredwork().getId());

            InfomationDTO result = new InfomationDTO();
            if(userEntity.getEmail()!=null)
                result.setEmail(userEntity.getEmail());
            if(userEntity.getPhone_number()!=null && !userEntity.getPhone_number().equals(""))
                result.setPhone_number(userEntity.getPhone_number());
            if(userEntity.getHomeTown()!=null && !userEntity.getHomeTown().equals(""))
                result.setHomeTown(userEntity.getHomeTown());
            if(userEntity.getGender()!=null && !userEntity.getGender().equals(""))
                result.setGender(userEntity.getGender());
            if(userEntity.getBirthday()!=null)
                result.setBirth_day(userEntity.getBirthday());
            if(userEntity.getAvatar()!=null && !userEntity.getAvatar().equals(""))
                result.setAvatar(userEntity.getAvatar());
            if(profileEntity.getSkill()!=null && !profileEntity.getSkill().equals(""))
                result.setSkill(profileEntity.getSkill());
            if(profileEntity.getNumberYearsExperience()!=null)
                result.setNumber_years_experience(profileEntity.getNumberYearsExperience());
            if(profileEntity.getDesiredWorkingAddress()!=null && !profileEntity.getDesiredWorkingAddress().equals(""))
                result.setDesired_working_address(profileEntity.getDesiredWorkingAddress());
            if(profileEntity.getDesiredSalary()!=null)
                result.setDesired_salary(profileEntity.getDesiredSalary());
            if(academic_levelEntity!=null){
                if(academic_levelEntity.getAcademicName()!=null && !academic_levelEntity.getAcademicName().equals(""))
                    result.setAcademic_name(academic_levelEntity.getAcademicName());
            }
            if(desiredWorkEntity.getDesiredworkname()!=null && !desiredWorkEntity.getDesiredworkname().equals(""))
                result.setDesiredworkname(desiredWorkEntity.getDesiredworkname());

            GenericResponse<Object> response = new GenericResponse<Object>(new Date(), HttpStatus.OK,
                    "Thành công", result);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Có lỗi xảy ra, vui lòng kiểm tra lại");
    }
    }


}
