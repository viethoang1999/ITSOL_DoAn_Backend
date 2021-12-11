package com.example.recruitmentwebsitesystem.entity;
import com.example.recruitmentwebsitesystem.entity.Profiles;
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
@Table(name = "desired_work")
public class Desiredwork implements Serializable{
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DESIRED_WORK_SEQ")
    @SequenceGenerator(name = "DESIRED_WORK_SEQ", sequenceName = "DESIRED_WORK_SEQ", allocationSize = 1, initialValue = 1)
    int id;
    @OneToOne(mappedBy = "desired_work", fetch = FetchType.EAGER)
    Profiles profiles;

    @Column(name = "desired_work|_name", nullable = false)
    String desiredworkname;

    @Column(name = "description", nullable = false)
    String description;

    @Column(name = "is_delete", nullable = false)
    boolean isDelete;
}
