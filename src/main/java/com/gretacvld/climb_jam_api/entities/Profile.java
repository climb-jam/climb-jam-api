package com.gretacvld.climb_jam_api.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private String avatarUrl;
    private String city;

    @Column(length = 5, nullable = false)
    private String postalCode;
}