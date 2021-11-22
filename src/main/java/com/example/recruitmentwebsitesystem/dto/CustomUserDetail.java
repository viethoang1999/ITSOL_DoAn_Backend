package com.example.recruitmentwebsitesystem.dto;

import com.example.recruitmentwebsitesystem.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;
import lombok.Data;

import net.minidev.json.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Data
public class CustomUserDetail implements UserDetails,OAuth2User {
    private Integer id;
    private String username;
    @JsonIgnore
    private String passWord;
    private String avatar;
    private String fullname;
    private String email;
    private String phone;
    private String gender;
    private Integer user_status;
    private String homeTown;
    private Date  birthday;
    private Integer roleID;
    private boolean isDelete;



    private Collection<? extends GrantedAuthority> authorities;

    private Map<String, Object> attributes;

    public CustomUserDetail(Integer id, String username, String passWord, String avatar, String fullname, String email, String phone, String gender, Integer user_status, String homeTown, Date birthday, Integer roleID, boolean isDelete, Collection<? extends GrantedAuthority> authorities) {
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
        this.roleID = roleID;
        this.isDelete = isDelete;
        this.authorities = authorities;
    }

    public static CustomUserDetail build(Users users){
        List<GrantedAuthority> authorities = users.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole().name()))
                .collect(Collectors.toList());

        return new CustomUserDetail(
                users.getId(),

                users.getPassWord(),
                users.getUserName(),
                users.getAvatar(),
                users.getFullName(),
                users.getEmail(),
                users.getPhone(),
                users.getGender(),
                users.getUserStatus(),
                users.getHomeTown(),
                users.getBirthday(),
                users.getRoleId(),
                users.isDelete(),
                authorities);
    }
    public static CustomUserDetail create(Users users, Map<String, Object> attributes) {
        CustomUserDetail userPrincipal = CustomUserDetail.build(users);
        userPrincipal.setAttributes(attributes);
        return userPrincipal;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getName() {
        return email;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CustomUserDetail user = (CustomUserDetail) o;
        return Objects.equals(id, user.id);
    }
}
