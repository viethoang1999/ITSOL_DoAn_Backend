package com.example.recruitmentwebsitesystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String full_name;
    private String email;
    private String user_name;
    private String password;
    private String phone_number;
    private String home_town;
    private String gender;
    private Date birth_day;
    private String avatar;
    private Integer user_status;
    private boolean is_delete;
}
