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
@Table(name = "reset_code")
public class ResetCode implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESET_CODE_SEQ")
    @SequenceGenerator(name = "RESET_CODE_SEQ", sequenceName = "RESET_CODE_SEQ", allocationSize = 1, initialValue = 1)
    int id;

    @Column(name = "code", nullable = false)
    int code;

    @Column(name = "create_date", nullable = false)
    Date createDate;

    @Column(name = "user_id", nullable = false)
    int userId;

    @Column(name = "is_delete", nullable = false)
    boolean isDelete;
}
