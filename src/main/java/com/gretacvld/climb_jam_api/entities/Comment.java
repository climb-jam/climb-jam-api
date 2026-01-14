package com.gretacvld.climb_jam_api.entities;

import com.gretacvld.climb_jam_api.enums.TargetType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private TargetType targetType;

    private Long targetId;

    @Column(columnDefinition = "TEXT")
    private String content;

    private Instant createdAt = Instant.now();
}