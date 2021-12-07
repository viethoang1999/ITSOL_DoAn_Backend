package com.example.recruitmentwebsitesystem.restcontroller;


import com.example.recruitmentwebsitesystem.dto.FormUpdateInformation;
import com.example.recruitmentwebsitesystem.dto.InformationUserDTO;
import com.example.recruitmentwebsitesystem.entity.Profiles;
import com.example.recruitmentwebsitesystem.entity.Users;
import com.example.recruitmentwebsitesystem.generic.impl.GenericResponse;
import com.example.recruitmentwebsitesystem.repo.UsersRepo;
import com.example.recruitmentwebsitesystem.service.ProfileService;
import com.example.recruitmentwebsitesystem.service.UsersService;
import com.example.recruitmentwebsitesystem.service.impl.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InformationController {

    @Autowired
    private InformationService informationService;

    @GetMapping("/getInfor/{id}")
    public List<InformationUserDTO> getInforById(@PathVariable("id")Integer userid){
        try {
            List<InformationUserDTO> informationUserDTOList = informationService.getInforById(userid);
            return informationUserDTOList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
//    @Autowired
//    private UsersService userService;
//
//    @Autowired
//    private ProfileService profileService;


//    @GetMapping("/getInformationUserById/{id}")
//    public ResponseEntity<?> getInformationUserById(@PathVariable("id") Integer id){
//        try {
//            Users userEntity = userService.findByID(id);
//            Profiles profileEntity = profileService.findByID(id);
//
////            InformationUserDTO result = new InformationUserDTO();
//            InformationUserDTO result = new InformationUserDTO();
//            result.setUsers(userEntity);
//            result.setProfiles(profileEntity);
//            if(userEntity==null || profileEntity==null) {
//                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy đối tượng");
//            }
//            GenericResponse<Object> response = new GenericResponse<Object>(new Date(), HttpStatus.OK,
//                    "Thành công", result);
//            return ResponseEntity.ok().body(response);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Có lỗi xảy ra, vui lòng kiểm tra lại");
//        }
//    }
//
//    public Date ConvertStringToDate(String StringDate) {
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            return (Date)dateFormat.parse(StringDate.trim());
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//

//    @PutMapping("/updateInformationUserById/{id}")
//    public ResponseEntity<?> updateInformationUserById(@PathVariable("id") Integer id,@RequestBody FormUpdateInformation form){
//        try {
//
//            Users userEntity = userService.findByID(id);
//            userEntity.setEmail(form.getEmail().trim());
//            userEntity.setPhone_number(form.getPhone().trim());
//            userEntity.setBirthday(ConvertStringToDate(form.getBirthday()));
//            userEntity.setAvatar(form.getAvatar().trim());
//            userEntity = userService.save(userEntity);
//            Profiles profileEntity = profileService.findByID(id);
//            profileEntity.setSkill(form.getSkill().trim());
//            profileEntity.setNumberYearsExperience(form.getNumberYearsExperience());
//            profileEntity.setDesiredSalary(form.getDesiredSalary());
//            profileEntity.setDesiredWorkingAddress(form.getDesiredWorkingAddress().trim());
//            profileEntity = profileService.save(profileEntity);
//            InformationUserDTO result = new InformationUserDTO();
//            result.setUsers(userEntity);
//            result.setProfiles(profileEntity);
//            if(userEntity==null || profileEntity==null) {
//                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy đối tượng");
//            }
//            GenericResponse<Object> response = new GenericResponse<Object>(new Date(), HttpStatus.OK,
//                    "Thành công", result);
//            return ResponseEntity.ok().body(response);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Có lỗi xảy ra, vui lòng kiểm tra lại");
//        }
//    }
}
