package com.gretacvld.climb_jam_api.entities;

import com.gretacvld.climb_jam_api.enums.Orientation;
import com.gretacvld.climb_jam_api.enums.Season;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Crag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;

    @Column(length = 5, nullable = false)
    private String postalCode;

    private BigDecimal latitude;
    private BigDecimal longitude;
    private Integer altitude;
    private String rockType;
    private String minGrade;
    private String maxGrade;
    private String exposure;

    @ElementCollection
    @CollectionTable(name = "crag_seasons", joinColumns = @JoinColumn(name = "crag_id"))
    @Enumerated(EnumType.STRING)
    private Set<Season> favorableSeasons = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "crag_orientations", joinColumns = @JoinColumn(name = "crag_id"))
    @Enumerated(EnumType.STRING)
    private Set<Orientation> orientations = new HashSet<>();

    private String photoUrl;
    private String thumbnailUrl;
}