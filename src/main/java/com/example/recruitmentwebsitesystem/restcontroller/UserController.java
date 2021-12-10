package com.example.recruitmentwebsitesystem.restcontroller;

import com.example.recruitmentwebsitesystem.EmailServicelmpl.EmailServicelmpl;
import com.example.recruitmentwebsitesystem.dto.PassWordDTO;
import com.example.recruitmentwebsitesystem.entity.OTP;
import com.example.recruitmentwebsitesystem.entity.Users;
import com.example.recruitmentwebsitesystem.service.impl.UserServiceimpl;
import com.example.recruitmentwebsitesystem.vm.UserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@CrossOrigin (origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserServiceimpl userService;
    @Autowired
    private UserServiceimpl userServiceimpl;
    @Autowired
    private EmailServicelmpl emailService;
    @GetMapping("/all")
    public List<Users> getAll(){
        return userService.getData();
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@Valid @RequestBody UserVM userVM, BindingResult result) {
        if(result.hasErrors()){
            return  ResponseEntity.badRequest().body(result.getAllErrors());
        }
        try {
            userService.validateUser(userVM);
            userService.add(userVM);
            return  ResponseEntity.ok().body(userVM);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("failed to create user");
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id , @RequestBody UserVM userVM) {
        try {
            userService.validateUser(userVM);
            userService.update(userVM,id);
            return  ResponseEntity.ok().body(userVM);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("failed to update user");
        }

    }
    @DeleteMapping("/{id}")
    public int delete(@PathVariable Integer id ) {
        return userService.deleteById(id);
    }
    @GetMapping("/search/{fullName}")
    public  List<Users> search(@PathVariable String fullName){
        return userService.searchName(fullName);

    }

    @GetMapping("/users/info/get-otp")
    public ResponseEntity<String> getOTP(){
        try {
            Users user = userService.loadUserFromContext();
            OTP otp = userService.retrieveNewOTP(user);
            emailService.sendSimpleMessage(user.getUserName(), "OTP", "OTP: " + otp.getCode());
            return ResponseEntity.ok().body("check email for OTP");
        }catch (RuntimeException e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/info/change-password")
    public ResponseEntity<String> changePasswordRequest(@RequestBody PassWordDTO passwordDTO){
        Users user = userService.loadUserFromContext();
        try {
            if(userService.verifyPassword(user, passwordDTO)){
                OTP otp = userService.retrieveNewOTP(user);
                emailService.sendSimpleMessage(user.getEmail(),
                        "Change password",
                        "OTP: " + otp.getCode() + "\nNew password: " + passwordDTO.getNewPassword());
                return ResponseEntity.ok().body("Check mail for OTP to commit changing");
            }else{
                return ResponseEntity.badRequest().body("Failed changing password");
            }
        }catch (RuntimeException e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/users/info/change-password")
    public ResponseEntity<String> changePassword(@RequestParam String otpCode, @RequestParam String password){
        try {
            Users user = userService.loadUserFromContext();
            OTP otp = userService.getOTPByUser(user);
            userService.verifyOTP(otp, otpCode);
            userService.changePassword(password, user);
            return ResponseEntity.ok().body("Password change successfull");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
