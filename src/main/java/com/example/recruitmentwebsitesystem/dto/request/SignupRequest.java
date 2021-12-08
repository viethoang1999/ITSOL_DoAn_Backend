package com.example.recruitmentwebsitesystem.dto.request;

import com.example.recruitmentwebsitesystem.entity.Role;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SignupRequest {

    @NotNull(message = "Username invalid!")
    @NotBlank(message = "Username invalid!")
    @Length(message = "Username invalid!", min = 6, max = 45)
    String username;

    @NotNull(message = "Password invalid!")
    @NotBlank(message = "Password invalid!")
    @Length(message = "Password invalid!", min = 6, max = 45)
    String password;

    @Column(name = "avatar", nullable = false)
    String avatar;


    @NotNull(message = "fullName invalid!")
    @NotBlank(message = "fullName invalid!")
    @Length(message = "fullName invalid!", min = 6, max = 45)
    private String fullname;

    @Email(message = "Email invalid!")
    @NotNull(message = "Email invalid!")
    @NotBlank(message = "Email invalid!")
    private String email;





    @Length(message = "Phone invalid!", min = 8, max = 15)
    @NotNull(message = "Phone invalid!")
    @NotBlank(message = "Phone invalid!")
    String phone;

    @NotNull(message = "homeTown invalid!")
    @NotBlank(message = "homeTown invalid!")
    @Length(message = "homeTown invalid!", min = 6, max = 45)
    String hometown;

    @Column(name = "gender", nullable = false)
    String gender;

    @Column(name = "birthday", nullable = false)
    Date birthday;


    @NotNull(message = "user_status invalid!")
    @Column(name = "user_status", nullable = false)
    Integer userstatus;

    @Column(name = "is_delete", nullable = false)
    boolean isdelete;

    private Set<String> role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Integer userstatus) {
        this.userstatus = userstatus;
    }

    public boolean isIsdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
