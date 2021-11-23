package com.example.recruitmentwebsitesystem.repo;

import com.example.recruitmentwebsitesystem.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationsRepo extends JpaRepository<Notifications,Integer> {
}
