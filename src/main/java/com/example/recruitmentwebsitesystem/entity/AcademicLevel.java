package com.example.recruitmentwebsitesystem.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "academic_level")
public class AcademicLevel implements Serializable {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACADEMIC_LEVEL_SEQ")
    @SequenceGenerator(name = "ACADEMIC_LEVEL_SEQ", sequenceName = "ACADEMIC_LEVEL_SEQ", allocationSize = 1, initialValue = 1)
    Integer id;

//    @OneToOne(mappedBy = "academicLevel", fetch = FetchType.EAGER)
//    Jobs jobs;
//
//    @OneToOne(mappedBy = "academicLevel", fetch = FetchType.EAGER)
//    Profiles profiles;

    @Column(name = "academic_name", nullable = false)
    String academicName;

    @Column(name = "description", nullable = false)
    String description;

    @Column(name = "is_delete", nullable = false)
    boolean isDelete;
}
