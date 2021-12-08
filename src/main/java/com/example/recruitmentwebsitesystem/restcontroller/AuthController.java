package com.example.recruitmentwebsitesystem.restcontroller;

import com.example.recruitmentwebsitesystem.dto.CustomUserDetail;
import com.example.recruitmentwebsitesystem.dto.request.SigninRequest;
import com.example.recruitmentwebsitesystem.dto.request.SignupRequest;
import com.example.recruitmentwebsitesystem.dto.response.JwtResponse;
import com.example.recruitmentwebsitesystem.dto.response.MessageResponse;
import com.example.recruitmentwebsitesystem.entity.ERole;
import com.example.recruitmentwebsitesystem.entity.Role;
import com.example.recruitmentwebsitesystem.entity.Users;
import com.example.recruitmentwebsitesystem.jwt.JwtHelper;
import com.example.recruitmentwebsitesystem.jwt.JwtTokenFilter;
import com.example.recruitmentwebsitesystem.repo.RoleRepo;
import com.example.recruitmentwebsitesystem.repo.UsersRepo;
import com.example.recruitmentwebsitesystem.service.UsersService;
import com.example.recruitmentwebsitesystem.service.impl.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    UsersService usersService;

    @Autowired
    JwtHelper jwtHelper;

    @Autowired
    JwtTokenFilter jwtTokenFilter;

    @Autowired
    CustomUserDetailService customUserDetailService;

//    @Autowired
//    AuthenticationMapper authenticationMapper;

    @PostMapping("/signup")
    public ResponseEntity<Object> registerUser(@Valid @RequestBody SignupRequest signupRequest){
        if (usersRepo.existsByUserName(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (usersRepo.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        Users user = new Users(signupRequest.getUsername(),
                encoder.encode(signupRequest.getPassword()),
                signupRequest.getAvatar(),
                signupRequest.getFullname(),
                signupRequest.getEmail(),
                signupRequest.getPhone(),
                signupRequest.getGender(),
                signupRequest.getHometown(),
                signupRequest.getBirthday(),
                signupRequest.getUserstatus(),
                signupRequest.isIsdelete());
        Set<String> strRoles= signupRequest.getRole();
        Set<Role> roles= new HashSet<>();
        if (strRoles==null){
            Role userRole = roleRepo.findByRole(ERole.USER)
                    .orElseThrow(()->new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        }else {
            strRoles.forEach(role->{
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepo.findByRole(ERole.ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "user":
                        Role userRole = roleRepo.findByRole(ERole.USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);

                        break;
                    default:
                        Role guestRole = roleRepo.findByRole(ERole.GUEST)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(guestRole);
                }
            });
        }
        user.setRoles(roles);
//        user.setProvider(AuthProvider.local);
        usersRepo.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> authenticateUser(@Valid @RequestBody SigninRequest signinRequest){
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signinRequest.getUsername(),signinRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtHelper.generateJwtToken(authentication);

        CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();
        List<String> roles = userDetail.getAuthorities().stream()
                .map(item->item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(token,
                userDetail.getId(),
                userDetail.getPassword(),
                userDetail.getUsername(),
                userDetail.getAvatar(),
                userDetail.getFullname(),
                userDetail.getEmail(),
                userDetail.getPhone(),
                userDetail.getGender(),
                userDetail.getUser_status(),
                userDetail.getHomeTown(),
                userDetail.getBirthday(),
                userDetail.isDelete(),
                roles));
    }
//    @PostMapping("/forgot")
//    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequest passwordReset) {
//        boolean forgotPassword = authenticationMapper.sendPasswordResetCode(passwordReset.getEmail());
//        if (!forgotPassword) {
//            throw new ApiRequestException("Email not found", HttpStatus.BAD_REQUEST);
//        }
//        return ResponseEntity.ok("Reset password code is send to your E-mail");
//    }
//
//    // reset password by otpCode
//    @GetMapping("/reset/{code}")
//    public ResponseEntity<UserResponse> getPasswordResetCode(@PathVariable String code) {
//        UserResponse user = authenticationMapper.findByOtpCode(code);
//        if (user == null) {
//            throw new ApiRequestException("Password reset code is invalid!", HttpStatus.BAD_REQUEST);
//        }
//        return ResponseEntity.ok(user);
//    }
//
//    @PostMapping("/reset")
//    public ResponseEntity<String> passwordReset(@RequestBody ForgotPasswordRequest passwordReset) {
//        if (authenticationMapper.isPasswordConfirmEmpty(passwordReset.getPassword2())) {
//            throw new PasswordConfirmException("Password confirmation cannot be empty.");
//        }
//        if (authenticationMapper.isPasswordDifferent(passwordReset.getPassword(), passwordReset.getPassword2())) {
//            throw new PasswordException("Passwords do not match.");
//        }
//        return ResponseEntity.ok(authenticationMapper.passwordReset(passwordReset.getEmail(), passwordReset.getPassword()));
//    }
//
//    @PutMapping("/changePassword")
//    public ResponseEntity<Object> changePassword(HttpServletRequest request, @Valid @RequestBody ChangePasswordRequest changePasswordRequest){
//        String jwt = jwtTokenFilter.parseJwt(request);
//        String username= jwtHelper.getUserNameFromJwtToken(jwt);
//        User user;
//        try {
//            user = userService.findByName(username);
//            if (user==null){
//                return new ResponseEntity<>("User Not Found with -> username"+username,HttpStatus.OK);
//            }
//            boolean matches= encoder.matches(changePasswordRequest.getCurrentPassword(),user.getPassword());
//            if (changePasswordRequest.getNewPassword()!=null){
//                if (matches){
//                    user.setPassword(encoder.encode(changePasswordRequest.getNewPassword()));
//                    userService.save(user);
//                }else {
//                    return new ResponseEntity<>(new MessageResponse("Password change failed"),HttpStatus.OK);
//                }
//            }
//            return new ResponseEntity<>(new MessageResponse("Change password successfully"),HttpStatus.OK);
//        }catch (UsernameNotFoundException e){
//            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.NOT_FOUND);
//        }
//    }
//    @PutMapping("/changeAvatar")
//    public ResponseEntity<Object> changeAvatar(HttpServletRequest request, @Valid @RequestBody ChangeAvatar changeAvatar){
//        String jwt = jwtTokenFilter.parseJwt(request);
//        String username= jwtHelper.getUserNameFromJwtToken(jwt);
//        User user;
//        try {
//            if (changeAvatar.getAvatar()==null){
//                return new ResponseEntity<>(new MessageResponse("No success"), HttpStatus.OK);
//            }else {
//                user = userService.findByName(username);
//                if (user==null){
//                    return new ResponseEntity<>("User Not Found with -> username"+username,HttpStatus.OK);
//                }
//                user.setAvatar(changeAvatar.getAvatar());
//                userService.save(user);
//            }
//            return new ResponseEntity<>(new MessageResponse("Change success"),HttpStatus.OK);
//        }catch (UsernameNotFoundException e){
//            return new ResponseEntity<>(new MessageResponse(e.getMessage()),HttpStatus.NOT_FOUND);
//        }
//    }
//    @PutMapping("/changeProfile")
//    public ResponseEntity<Object> changProfile(HttpServletRequest request,@Valid @RequestBody ChangeProfile changeProfile){
//        String jwt = jwtTokenFilter.parseJwt(request);
//        String username= jwtHelper.getUserNameFromJwtToken(jwt);
//        User user;
//        try {
//            if(userService.existByUserName(changeProfile.getUsername())){
//                return new ResponseEntity<>(new MessageResponse("No user"), HttpStatus.OK);
//            }
//            if(userService.existByEmail(changeProfile.getEmail())){
//                return new ResponseEntity<>(new MessageResponse("No email"), HttpStatus.OK);
//            }
//            user = userService.findByName(username);
//            if (user==null){
//                return new ResponseEntity<>("User Not Found with -> username"+username,HttpStatus.OK);
//            }
//            user.setUsername(changeProfile.getUsername());
//            user.setFullname(changeProfile.getFullname());
//            user.setPhone(changeProfile.getPhone());
//            user.setGender(changeProfile.getGender());
//            user.setStatus(changeProfile.getStatus());
//            user.setEmail(changeProfile.getEmail());
//            userService.save(user);
//            return new ResponseEntity<>(new MessageResponse("Change success"), HttpStatus.OK);
//        } catch (UsernameNotFoundException e){
//            return new ResponseEntity<>(new MessageResponse(e.getMessage()),HttpStatus.NOT_FOUND );
//        }
//    }
}
