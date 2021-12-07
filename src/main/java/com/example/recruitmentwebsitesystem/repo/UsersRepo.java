package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.dto.InformationUserDTO;
import com.example.recruitmentwebsitesystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {
//    Users findByUsername(String user_name);
//
//    Boolean existsByUsername(String username);
//
//    Boolean existsByEmail(String email);
//
//    Users findByOtpCode(String code);
//
//    Users findByEmail(String email);

    @Query(value = "select us.full_name, us.email, us.phone_number, us.home_town, us.gender, us.birth_day, us.avatar, pr.skill, " +
            "pr.number_years_experience, pr.desired_salary, pr.desired_working_address, al.academic_name,dw.desiredworkname " +
            "from  users us inner join profiles pr on  us.id = pr.user_id  " +
            "    inner join academic_level al on pr.academic_level_id = al.id " +
            "    inner join desiredwork dw on pr.desire_id = dw.id " +
            "where  us.is_delete = 0 and pr.is_delete = 0 and al.is_delete =0 and dw.is_delete =0 and us.id = :userid ",nativeQuery = true)
    public List<InformationUserDTO> getInforbyId(@Param("userid") Integer userid);
}
