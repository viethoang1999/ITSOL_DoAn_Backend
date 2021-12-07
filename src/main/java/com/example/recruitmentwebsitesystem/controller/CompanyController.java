package com.example.recruitmentwebsitesystem.controller;

import com.example.recruitmentwebsitesystem.entity.Company;
import com.example.recruitmentwebsitesystem.generic.BaseService;
import com.example.recruitmentwebsitesystem.generic.impl.GenericController;
import com.example.recruitmentwebsitesystem.generic.impl.GenericResponse;
import com.example.recruitmentwebsitesystem.service.CompanyService;
import com.example.recruitmentwebsitesystem.service.impl.CompanyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController extends GenericController<Company, Integer> {
    @Autowired
    private CompanyImpl companyService;
    public CompanyController(BaseService<Company, Integer> baseService) {

        super(baseService);
    }

    @GetMapping("/all")
    public List<Company> getCompany()
    {
        return companyService.getListAll();
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Company newCompanyEntity){
        try {
            if(newCompanyEntity.getName()==null || newCompanyEntity.getName().equals("")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vui lòng nhập tên");
            }
            if(newCompanyEntity.getEmail()==null || newCompanyEntity.getEmail().equals("")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vui lòng nhập email");
            }
            if(newCompanyEntity.getHotLine()==null || newCompanyEntity.getHotLine().equals("")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vui lòng nhập hot line");
            }
            if(newCompanyEntity.getDateIncorporation()==null || newCompanyEntity.getDateIncorporation().equals("")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vui lòng nhập ngày thành lập");
            }
            if(newCompanyEntity.getTaxCode()==null || newCompanyEntity.getTaxCode().equals("")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vui lòng nhập mã số thuế");
            }
            if(newCompanyEntity.getTaxDate()==null || newCompanyEntity.getTaxDate().equals("")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vui lòng nhập ngày cấp mã số thuế");
            }
            if(newCompanyEntity.getTaxPlace()==null || newCompanyEntity.getTaxPlace().equals("")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vui lòng nhập nơi cấp mã số thuế");
            }

            Company companyEntity = new Company();
            companyEntity.setName(newCompanyEntity.getName().trim());
            companyEntity.setHotLine(newCompanyEntity.getHotLine().trim());
            companyEntity.setEmail(newCompanyEntity.getEmail().trim());
            companyEntity.setDateIncorporation(newCompanyEntity.getDateIncorporation());
            companyEntity.setTaxCode(newCompanyEntity.getTaxCode().trim());
            companyEntity.setTaxDate(newCompanyEntity.getTaxDate());
            companyEntity.setTaxPlace(newCompanyEntity.getTaxPlace().trim());
            companyEntity.setHeadOffice(newCompanyEntity.getHeadOffice().trim());
            companyEntity.setNumberStaff(newCompanyEntity.getNumberStaff());
            companyEntity.setLinkWeb(newCompanyEntity.getLinkWeb().trim());
            companyEntity.setDescription(newCompanyEntity.getDescription().trim());
            companyEntity.setAvatar(newCompanyEntity.getAvatar().trim());
            companyEntity.setBackdropImg(newCompanyEntity.getBackdropImg().trim());
            companyEntity.setDelete(newCompanyEntity.isDelete());
            companyEntity = companyService.save(companyEntity);
            GenericResponse<Object> response = new GenericResponse<Object>(new Date(), HttpStatus.OK,
                    "Thành công", companyEntity);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Có lỗi xảy ra, vui lòng kiểm tra lại");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,@RequestBody Company newCompanyEntity){
        try {
            Company companyEntity = companyService.findByID(id);
            if(newCompanyEntity.getName()==null || newCompanyEntity.getName().equals("")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vui lòng nhập tên");
            }
            if(newCompanyEntity.getEmail()==null || newCompanyEntity.getEmail().equals("")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vui lòng nhập email");
            }
            if(newCompanyEntity.getHotLine()==null || newCompanyEntity.getHotLine().equals("")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vui lòng nhập hot line");
            }
            if(newCompanyEntity.getDateIncorporation()==null || newCompanyEntity.getDateIncorporation().equals("")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vui lòng nhập ngày thành lập");
            }
            if(newCompanyEntity.getTaxCode()==null || newCompanyEntity.getTaxCode().equals("")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vui lòng nhập mã số thuế");
            }
            if(newCompanyEntity.getTaxDate()==null || newCompanyEntity.getTaxDate().equals("")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vui lòng nhập ngày cấp mã số thuế");
            }
            if(newCompanyEntity.getTaxPlace()==null || newCompanyEntity.getTaxPlace().equals("")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vui lòng nhập nơi cấp mã số thuế");
            }

            companyEntity.setName(newCompanyEntity.getName().trim());
            companyEntity.setHotLine(newCompanyEntity.getHotLine().trim());
            companyEntity.setEmail(newCompanyEntity.getEmail().trim());
            companyEntity.setDateIncorporation(newCompanyEntity.getDateIncorporation());
            companyEntity.setTaxCode(newCompanyEntity.getTaxCode().trim());
            companyEntity.setTaxDate(newCompanyEntity.getTaxDate());
            companyEntity.setTaxPlace(newCompanyEntity.getTaxPlace().trim());
            companyEntity.setHeadOffice(newCompanyEntity.getHeadOffice().trim());
            companyEntity.setNumberStaff(newCompanyEntity.getNumberStaff());
            companyEntity.setLinkWeb(newCompanyEntity.getLinkWeb().trim());
            companyEntity.setDescription(newCompanyEntity.getDescription().trim());
            companyEntity.setAvatar(newCompanyEntity.getAvatar().trim());
            companyEntity.setBackdropImg(newCompanyEntity.getBackdropImg().trim());
            companyEntity.setDelete(newCompanyEntity.isDelete());
            companyEntity = companyService.save(companyEntity);
            GenericResponse<Object> response = new GenericResponse<Object>(new Date(), HttpStatus.OK,
                    "Thành công", companyEntity);
            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Có lỗi xảy ra, vui lòng kiểm tra lại");
        }
    }
}
