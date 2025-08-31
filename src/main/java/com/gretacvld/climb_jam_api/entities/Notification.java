package com.gretacvld.climb_jam_api.entities;

import com.gretacvld.climb_jam_api.enums.NotificationStatus;
import com.gretacvld.climb_jam_api.enums.NotificationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private NotificationType type = NotificationType.SYSTEM;

    private String content;

    @Enumerated(EnumType.STRING)
    private NotificationStatus status = NotificationStatus.UNREAD;

    private Instant createdAt = Instant.now();
}