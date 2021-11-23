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
@Table(name = "notifications")
public class Notifications implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTIFICATIONS_SEQ")
    @SequenceGenerator(name = "NOTIFICATIONS_SEQ", sequenceName = "NOTIFICATIONS_SEQ", allocationSize = 1, initialValue = 1)
    int id;

    @Column(name = "sender_id", nullable = false)
    int senderId;

    @Column(name = "receiver_id", nullable = false)
    int receiverId;

    @Column(name = "create_date", nullable = false)
    Date createDate;

    @Column(name = "content", nullable = false)
    String content;

    @Column(name = "res_id", nullable = false)
    int resId;

    @Column(name = "type_id", nullable = false)
    int typeId;

    @Column(name = "is_delete", nullable = false)
    boolean isDelete;
}
