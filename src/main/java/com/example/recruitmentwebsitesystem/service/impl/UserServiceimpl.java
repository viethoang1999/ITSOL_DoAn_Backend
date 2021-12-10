package com.example.recruitmentwebsitesystem.service.impl;


import com.example.recruitmentwebsitesystem.EmailServicelmpl.EmailServicelmpl;
import com.example.recruitmentwebsitesystem.Utils.CommonConst;
import com.example.recruitmentwebsitesystem.dto.PassWordDTO;
import com.example.recruitmentwebsitesystem.entity.OTP;
import com.example.recruitmentwebsitesystem.entity.Role;
import com.example.recruitmentwebsitesystem.entity.Users;
import com.example.recruitmentwebsitesystem.generic.impl.GenericServiceImpl;
import com.example.recruitmentwebsitesystem.repo.IUserRespository;
import com.example.recruitmentwebsitesystem.repo.OTPRepo;
import com.example.recruitmentwebsitesystem.repo.RoleRepo;
import com.example.recruitmentwebsitesystem.repo.UsersRepo;
import com.example.recruitmentwebsitesystem.service.UserService;
import com.example.recruitmentwebsitesystem.vm.UserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceimpl implements UserService{

    @Autowired
    RoleRepo roleRepo;
    @Autowired
    IUserRespository userRepo;
    @Autowired
    OTPRepo otpRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    EmailServicelmpl emailService;
    @Autowired
    IUserRespository iUserRespository;

    public UserServiceimpl(PasswordEncoder passwordEncoder, EmailServicelmpl emailService) {
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    public List<Users> getData() {
        return iUserRespository.findAll();
    }

    public int add(UserVM userVM) {
        Users newUser = new Users();
        try {
            boolean check = validateUser(userVM);
            if (!check) {
                System.out.println("........");
                return 0;
            }
            newUser.setGender(userVM.getGender());
            newUser.setEmail(userVM.getEmail());
            newUser.setHomeTown(userVM.getHomeTown());
            newUser.setPhone_number(userVM.getPhoneNumber());
            newUser.setFullName(userVM.getFullName());
            newUser.setUserName(userVM.getUserName());
            newUser.setPassWord(passwordEncoder.encode(userVM.getPassword()));
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            try {
                newUser.setBirthday(sdf.parse(userVM.getBirthDay()));
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
            iUserRespository.save(newUser);
            return CommonConst.SUCCESS;
        } catch (Exception e) {
            return CommonConst.ERROR;
        }
    }

    public boolean validateUser(UserVM userVM) {
        return true;
    }

    public int update(UserVM userVM, Integer id) {
        Users newUser = new Users();
        try {
            boolean check = validateUser(userVM);
            if (!check) {
                System.out.println("........");
                return 0;
            }
            newUser.setId(id);
            newUser.setGender(userVM.getGender());
            newUser.setEmail(userVM.getEmail());
            newUser.setHomeTown(userVM.getHomeTown());
            newUser.setPhone_number(userVM.getPhoneNumber());
            newUser.setFullName(userVM.getFullName());
            newUser.setUserName(userVM.getUserName());
            newUser.setPassWord(userVM.getPassword());
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            try {
                newUser.setBirthday(sdf.parse(userVM.getBirthDay()));
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
            iUserRespository.save(newUser);
            return CommonConst.SUCCESS;
        } catch (Exception e) {
            return CommonConst.ERROR;
        }
    }
    public int deleteById(Integer deletepcId) {
        try {
            iUserRespository.deleteById(deletepcId);
            return CommonConst.SUCCESS;
        } catch (Exception e) {
            // TODO: handle exception
            return CommonConst.ERROR;
        }
    }
    public List<Users> searchName(String fullName){
        List<Users> list = new ArrayList<Users>();
        if(fullName.isEmpty()){
            list = userRepo.findAll();
        }else {
            list = userRepo.findByFullName(fullName);
        }
        return list;
    }

    @Override
    public Users saveUser(Users user) {
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public OTP saveOTP(OTP otp) {
        return otpRepo.save(otp);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        Users user = userRepo.findByUserName(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public Users getUser(String username) {
        return   userRepo.findByUserName(username);
    }

    @Override
    public Users getUserById(Long id) {
        try {
            Users user =  userRepo.getUserById(id);
            return user;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public OTP generateOTP(Users user) {
        OTP otp = new OTP(user);
        return saveOTP(otp);
    }

    @Override
    public OTP getOTPByUser(Users user) {
        return otpRepo.findByUser(user).orElse(null);
    }

    @Override
    public void verifyOTP(OTP otp, String otpCode) {
        if(!otp.getCode().equals(otpCode)){
            throw new RuntimeException("Wrong opt code");
        }else if(otp.isExpired()){
            throw new RuntimeException("OTP is expired");
        }
    }

    @Override
    public OTP retrieveNewOTP(Users user) {
        OTP otp = getOTPByUser(user);
        if(otp == null){
            otp = generateOTP(user);
            return otp;
        }else{
            OTP newOTP = new OTP();
            otp.setCode(newOTP.getCode());
            otp.setIssueAt(newOTP.getIssueAt());
            return otp;
        }
    }

    @Override
    public void activeAccount(Users user) {
        user.setActive(true);
    }

    @Override
    public boolean verifyPassword(Users user, PassWordDTO passwordDTO) {
        if(passwordDTO.getNewPassword() == null ||
                passwordDTO.getVerifyNewPassword() == null ||
                passwordDTO.getCurrentPassword() == null ||
                !passwordDTO.getNewPassword().equals(passwordDTO.getVerifyNewPassword()) ||
                !passwordEncoder.matches(passwordDTO.getCurrentPassword(), user.getPassWord())){
            return false;
        }
        return true;
    }

    @Override
    public void changePassword(String password, Users user) {
        user.setPassWord(passwordEncoder.encode(password));
    }

    @Override
    public Users loadUserFromContext() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return getUser(username);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users user = userRepo.findByUserName(userName);
        if(user == null){
            throw new UsernameNotFoundException("Cannot find this user");
        }
        List<SimpleGrantedAuthority> authorities =new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassWord(), true, true, true, user.isActive(), authorities);
    }
}
