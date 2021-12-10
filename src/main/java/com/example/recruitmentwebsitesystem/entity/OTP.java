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
@Table(name = "OTP")
public class OTP implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OTP_SEQ")
    @SequenceGenerator(name = "OTP_SEQ", sequenceName = "OTP_SEQ", allocationSize = 1, initialValue = 1)
    int id;

    @ManyToOne(targetEntity = Users.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    Users users;

    @Column(name = "code", nullable = false)
    int code;

    @Column(name = "create_date", nullable = false)
    Date createDate;

    @Column(name = "is_delete", nullable = false)
    boolean isDelete;
}
