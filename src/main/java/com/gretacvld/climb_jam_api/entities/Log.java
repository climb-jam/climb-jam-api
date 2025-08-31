package com.gretacvld.climb_jam_api.entities;

import com.gretacvld.climb_jam_api.enums.ItemType;
import com.gretacvld.climb_jam_api.enums.LogAction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(indexes = {@Index(columnList = "user_id, createdAt"), @Index(columnList = "itemType, itemId")})
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private LogAction action;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    private Long itemId;

    @Column(columnDefinition = "TEXT")
    private String details;

    private Instant createdAt = Instant.now();
}