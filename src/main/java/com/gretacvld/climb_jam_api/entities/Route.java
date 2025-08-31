package com.gretacvld.climb_jam_api.entities;

import com.gretacvld.climb_jam_api.enums.ClimbingType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(indexes = {@Index(columnList = "crag_id")})
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Crag crag;

    private String name;

    @ElementCollection
    @CollectionTable(name = "route_climbing_types", joinColumns = @JoinColumn(name = "route_id"))
    @Enumerated(EnumType.STRING)
    private Set<ClimbingType> climbingTypes = new HashSet<>();

    private String grade;
    private Integer height;
    private String inclineType;
    private String anchorType;
    private String boltType;
    private Integer boltCount;
    private String sector;
}