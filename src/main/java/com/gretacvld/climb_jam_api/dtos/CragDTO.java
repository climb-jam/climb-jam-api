package com.gretacvld.climb_jam_api.dtos;

import com.gretacvld.climb_jam_api.enums.Orientation;
import com.gretacvld.climb_jam_api.enums.Season;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CragDTO {

    private Long id;

    @NotBlank(message = "Le nom est obligatoire.")
    private String name;

    @NotBlank(message = "La ville est obligatoire.")
    private String city;

    @NotBlank(message = "Le code postal est obligatoire.")
    @Pattern(
            regexp = "\\d{5}",
            message = "Le code postal doit contenir 5 chiffres."
    )
    private String postalCode;

    private Double lat;
    private Double lon;
    private Integer altitude;
    private String rockType;
    private String minGrade;
    private String maxGrade;
    private String exposure;

    private Set<Season> favorableSeasons;
    private Set<Orientation> orientations;

    private String photoUrl;
    private String thumbnailUrl;
}