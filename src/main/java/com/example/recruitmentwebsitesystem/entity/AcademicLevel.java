package com.example.recruitmentwebsitesystem.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "academic_level")
public class AcademicLevel implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACADEMIC_LEVEL_SEQ")
    @SequenceGenerator(name = "ACADEMIC_LEVEL_SEQ", sequenceName = "ACADEMIC_LEVEL_SEQ", allocationSize = 1, initialValue = 1)
    int id;

    @OneToOne(targetEntity = Jobs.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "jobs_id", nullable = false)
    Jobs jobs;

    @OneToOne(targetEntity = Profiles.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    Profiles profiles;

    @Column(name = "academic_name", nullable = false)
    String academicName;

    @Column(name = "description", nullable = false)
    String description;

    @Column(name = "is_delete", nullable = false)
    boolean isDelete;
}
