package com.example.recruitmentwebsitesystem.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "jobs_register")
public class JobsRegister implements Serializable {
//    @Id
//    @ManyToOne(targetEntity = Jobs.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "job_id", nullable = false)
//    Jobs jobs;
//
//    @Id
//    @ManyToOne(targetEntity = Users.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "job_id", nullable = false)
//    Users users;
    @EmbeddedId
    CompositeJobsReg compositeJobsReg;

    @Column(name = "date_register", nullable = false)
    Date dateRegister;

    @Column(name = "profile_status_id", nullable = false)
    int profileStatusId;

    @Column(name = "date_interview", nullable = false)
    Date dateInterview;

    @Column(name = "method_interview", nullable = false)
    String methodInterview;

    @Column(name = "cv_file", nullable = false)
    String cvFile;

    @Column(name = "is_delete", nullable = false)
    boolean isDelete;
}
