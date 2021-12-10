package com.example.recruitmentwebsitesystem.restcontroller;

import com.example.recruitmentwebsitesystem.EmailServicelmpl.EmailServicelmpl;
import com.example.recruitmentwebsitesystem.dto.UserSignupDTO;
import com.example.recruitmentwebsitesystem.entity.OTP;
import com.example.recruitmentwebsitesystem.entity.Role;
import com.example.recruitmentwebsitesystem.entity.Users;
import com.example.recruitmentwebsitesystem.repo.RoleRepo;
import com.example.recruitmentwebsitesystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
@RestController
@RequiredArgsConstructor
public class AccountController {
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    private final EmailServicelmpl emailService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserSignupDTO userSignupDTO) {
        Users user = new Users();
        Role role =roleRepo.findByName("ROLE_USER");
        user.setFullName(userSignupDTO.getFullName());
        user.setEmail(userSignupDTO.getEmail());
        user.setPhone_number(userSignupDTO.getPhoneNumber());
        user.setHomeTown(userSignupDTO.getHomeTown());
        user.setGender(userSignupDTO.getGender());
        user.setUserName(userSignupDTO.getUserName());
        user.setPassWord(passwordEncoder.encode(userSignupDTO.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            user.setBirthday(sdf.parse(userSignupDTO.getBirthDay()));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        user.setActive(false);
        user.setIsDelete(0); //  0 => deleted = false
        userService.saveUser(user);
        OTP otp = userService.generateOTP(user);
        String linkActive = "http://localhost:8080/active/" + user.getId();
        emailService.sendSimpleMessage(user.getEmail(),
                "Link active account",
                "<a href=\" "+ linkActive +"\">Click vào đây để kích hoạt tài khoản</a>");
        return ResponseEntity.ok().body("check email for OTP");
    }

    @GetMapping("/active/{id}")
    public ResponseEntity<String> activeAccount(@PathVariable Long id) {
        try {
            Users user = userService.getUserById(id);
            if (user.isActive()) {
                return ResponseEntity.ok().body("Your account is already activated");
            }
            userService.activeAccount(user);
            return ResponseEntity.ok().body("Active successfull");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
