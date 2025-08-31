package com.gretacvld.climb_jam_api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(indexes = {@Index(columnList = "user_id"), @Index(columnList = "route_id"), @Index(columnList = "session_id")})
public class Ascent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Route route;

    @ManyToOne
    private Session session;

    private LocalDate date;
    private String style;
    private Integer tries = 1;

    @Column(columnDefinition = "TEXT")
    private String comment;
}