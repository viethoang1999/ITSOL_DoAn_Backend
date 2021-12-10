package com.example.recruitmentwebsitesystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Component
public class JobsRegister implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOBS_REGISTER_SEQ")
    @SequenceGenerator(name = "JOBS_REGISTER_SEQ", sequenceName = "JOBS_REGISTER_SEQ", allocationSize = 1, initialValue = 1)
    int id;

//    @OneToOne(targetEntity = Users.class, fetch = FetchType.EAGER)
    @Column(name = "user_id", nullable = false)
    int user_id;

//    @ManyToOne(targetEntity = ProfileStatus.class, fetch = FetchType.EAGER)
    @Column(name = "profile_status_id", nullable = false)
    int profile_status_id;

    @Column(name = "vacancies", nullable = false)
    String vacancies;

    @Column(name = "application_time", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    Date application_time;

    @Column(name = "status", nullable = false)
    String status;

    @Column(name = "cv_file", nullable = false)
    String cvFile;

    @Column(name = "is_delete", nullable = false)
    boolean isDelete;
}
