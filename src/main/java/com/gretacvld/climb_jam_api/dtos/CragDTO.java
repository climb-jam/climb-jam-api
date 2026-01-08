package com.gretacvld.climb_jam_api.dtos;

import com.gretacvld.climb_jam_api.enums.Orientation;
import com.gretacvld.climb_jam_api.enums.Season;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CragDTO {

    private Long id;
    private Boolean isFav;
    @NotBlank(message = "Le nom est obligatoire.")
    private String name;

    @NotBlank(message = "La ville est obligatoire.")
    private String city;

    @NotBlank(message = "Le code postal est obligatoire.")
    @Size(min = 5, max = 5, message = "Le code postal doit contenir 5 caractères.")
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
    public CragDTO(com.gretacvld.climb_jam_api.entities.Crag crag) {
        this.id = crag.getId();
        this.name = crag.getName();
        this.city = crag.getCity();
        this.postalCode = crag.getPostalCode();
        this.lat = crag.getLat();
        this.lon = crag.getLon();
        this.altitude = crag.getAltitude();
        this.rockType = crag.getRockType();
        this.minGrade = crag.getMinGrade();
        this.maxGrade = crag.getMaxGrade();
        this.exposure = crag.getExposure();
        this.favorableSeasons = crag.getFavorableSeasons();
        this.orientations = crag.getOrientations();
        this.photoUrl = crag.getPhotoUrl();
        this.thumbnailUrl = crag.getThumbnailUrl();
        // Si tu gères les favoris ailleurs, initialise isFav ici ou laisse null
        this.isFav = null;
    }

}