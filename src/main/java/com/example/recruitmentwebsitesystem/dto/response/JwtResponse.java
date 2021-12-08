package com.example.recruitmentwebsitesystem.dto.response;

import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Integer id;
    private String username;
    private String passWord;
    private String avatar;
    private String fullname;
    private String email;
    private String phone;
    private String gender;
    private Integer user_status;
    private String homeTown;
    private Date birthday;
    private boolean isDelete;
    private List<String> roles;

    public JwtResponse(String token,  Integer id, String username, String passWord, String avatar, String fullname, String email, String phone, String gender, Integer user_status, String homeTown, Date birthday, boolean isDelete, List<String> roles) {
        this.token = token;

        this.id = id;
        this.username = username;
        this.passWord = passWord;
        this.avatar = avatar;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.user_status = user_status;
        this.homeTown = homeTown;
        this.birthday = birthday;
        this.isDelete = isDelete;
        this.roles = roles;
    }
}
