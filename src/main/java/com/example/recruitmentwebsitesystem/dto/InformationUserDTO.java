package com.example.recruitmentwebsitesystem.dto;

import com.example.recruitmentwebsitesystem.entity.Profiles;
import com.example.recruitmentwebsitesystem.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

public interface InformationUserDTO {

    //    private Users users;
//    private Profiles profiles;
//
//    public InformationUserDTO(Users users, Profiles profiles) {
//        super();
//        this.users = users;
//        this.profiles = profiles;
//    }
//
//    public InformationUserDTO() {
//        super();
//    }
//
//    public void setUsers(Users users) {
//        this.users = users;
//    }
//
//    public void setProfiles(Profiles profiles) {
//        this.profiles = profiles;
//    }
//
//    public Users getUsers() {
//        return users;
//    }
//
//    public Profiles getProfiles() {
//        return profiles;
//    }
    public  String getfull_name();
    public String getEmail();

    public String getPhone_number();

    public String getHome_town();

    public String getGender();

    public String getBirth_day();

    public String getAvatar();

    public String getSkill();

    public int getNumber_years_experience();

    public int getDesired_salary();

    public String getDesired_working_address();

    public String getAcademic_name();

    public String getDesiredworkname();
}
