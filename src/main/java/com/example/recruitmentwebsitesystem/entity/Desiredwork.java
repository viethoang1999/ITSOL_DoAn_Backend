package com.example.recruitmentwebsitesystem.entity;

import javax.persistence.*;
import java.io.Serializable;

public class Desiredwork implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DESIRED_WORK_SEQ")
    @SequenceGenerator(name = "DESIRED_WORK_SEQ", sequenceName = "DESIRED_WORK_SEQ", allocationSize = 1, initialValue = 1)
    int id;
    @OneToOne(mappedBy = "desiredwork", fetch = FetchType.EAGER)
    Profiles profiles;

    @Column(name = "desiredworkname", nullable = false)
    String methodName;

    @Column(name = "description", nullable = false)
    String description;

    @Column(name = "is_delete", nullable = false)
    boolean isDelete;
}
