package com.gretacvld.climb_jam_api.repositories;

import com.gretacvld.climb_jam_api.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUserId(Long userId);
}