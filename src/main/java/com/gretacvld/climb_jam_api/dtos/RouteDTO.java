package com.gretacvld.climb_jam_api.dtos;

import com.gretacvld.climb_jam_api.enums.ClimbingType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RouteDTO {

    private Long id;

    @NotNull(message = "Le site d'escalade est obligatoire.")
    private CragDTO crag;

    @NotBlank(message = "Le nom  de la voie est obligatoire.")
    private String name;

    private Set<ClimbingType> climbingTypes;

    private String grade;
    private Integer height;
    private String inclineType;
    private String anchorType;
    private String boltType;
    private Integer boltCount;
    private String sector;
}