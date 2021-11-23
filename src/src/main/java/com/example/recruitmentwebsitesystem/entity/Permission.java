package com.example.recruitmentwebsitesystem.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "permission")
public class Permission implements Serializable {
//    @Id
//    @ManyToOne(targetEntity = Role.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "role_id", nullable = false)
//    int role_id;
//
//    @Id
//    @ManyToOne(targetEntity = Users.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false)
//    int user_id;
    @EmbeddedId
    CompositePermission compositePermission;
}
