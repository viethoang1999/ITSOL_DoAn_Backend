package com.example.recruitmentwebsitesystem.entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "desired_work")
public class DesiredWork {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DESIRED_WORK_SEQ")
    @SequenceGenerator(name = "DESIRED_WORK_SEQ", sequenceName = "DESIRED_WORK_SEQ", allocationSize = 1, initialValue = 1)
    int Id;

    @Column(name = "desired_work_name ", nullable = false)
    String desiredWorkName;

    @Column(name = "description ", nullable = false)
    String description;

    @Column(name = "is_delete", nullable = false)
    boolean isDelete;
}
