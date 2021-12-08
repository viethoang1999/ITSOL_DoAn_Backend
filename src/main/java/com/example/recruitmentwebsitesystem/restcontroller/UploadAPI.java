//package com.example.recruitmentwebsitesystem.restcontroller;
//
//import com.example.recruitmentwebsitesystem.entity.Users;
//import com.example.recruitmentwebsitesystem.repo.UsersRepo;
//import com.example.recruitmentwebsitesystem.service.UsersService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//
//import java.util.Date;
//import java.util.Date;
//
//@RestController
//@RequestMapping("/api/upload")
//public class UploadAPI {
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    private UsersRepo usersRepo;
//
//
//    @GetMapping("/test")
//    public UsersService createAdmin() {
//        Users user = new Users();
//
//
//        {
//            user.setUserName("admin0");
//            user.setUserName("1");
//            user.setFullName("Phúc");
//            user.setEmail("phuc12343j@gmail.com");
//            // hash pass
//            user.setUserName(passwordEncoder.encode(user.getPassWord()));
//
//
//            // save user
//            usersRepo.save(user);
//
//        }
//
//    }
//}
