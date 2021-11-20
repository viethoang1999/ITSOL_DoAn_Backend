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
@Table(name = "jobs")
public class Jobs implements Serializable {
    @Id
    @Column(name = "job_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOBS_SEQ")
    @SequenceGenerator(name = "JOBS_SEQ", sequenceName = "JOBS_SEQ", allocationSize = 1, initialValue = 1)
    int id;

    @Column(name = "job_name", nullable = false)
    String jobName;

    @Column(name = "job_position", nullable = false)
    String jobPosition;

    @Column(name = "number_experience", nullable = false)
    String numberExperience;

    @Column(name = "method_work_id", nullable = false)
    int methodWorkId;

    @Column(name = "address_work", nullable = false)
    String addressWork;

    @Column(name = "academic_level_id", nullable = false)
    int academicLevelId;

    @Column(name = "level_id", nullable = false)
    int levelId;

    @Column(name = "quantity_person", nullable = false)
    int quantityPerson;

    @Column(name = "due_date", nullable = false)
    Date dueDate;

    @Column(name = "skills", nullable = false)
    String skills;

    @Column(name = "description", nullable = false)
    String description;

    @Column(name = "interest", nullable = false)
    String interest;

    @Column(name = "salary", nullable = false)
    float salary;

    @Column(name = "contact_id", nullable = false)
    int contactId;

    @Column(name = "job_status_id", nullable = false)
    int jobStatusId;

    @Column(name = "view", nullable = false)
    int view;

    @Column(name = "create_id", nullable = false)
    int createId;

    @Column(name = "is_delete", nullable = false)
    boolean isDelete;
}
