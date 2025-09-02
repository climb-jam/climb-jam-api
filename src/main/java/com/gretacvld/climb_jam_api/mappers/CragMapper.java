package com.gretacvld.climb_jam_api.mappers;

import com.gretacvld.climb_jam_api.dtos.CragDTO;
import com.gretacvld.climb_jam_api.entities.Crag;

public class CragMapper {

    // Entity Crag ==> DTO CragDTO
    public static CragDTO toDTO(Crag crag) {
        return new CragDTO(
                crag.getId(),
                crag.getName(),
                crag.getCity(),
                crag.getPostalCode(),
                crag.getLatitude(),
                crag.getLongitude(),
                crag.getAltitude(),
                crag.getRockType(),
                crag.getMinGrade(),
                crag.getMaxGrade(),
                crag.getExposure(),
                crag.getFavorableSeasons(),
                crag.getOrientations(),
                crag.getPhotoUrl(),
                crag.getThumbnailUrl()
        );
    }

    // DTO CragDTO ==> Entity Crag
    public static Crag toEntity(CragDTO dto) {
        return new Crag(
                dto.getId(),
                dto.getName(),
                dto.getCity(),
                dto.getPostalCode(),
                dto.getLatitude(),
                dto.getLongitude(),
                dto.getAltitude(),
                dto.getRockType(),
                dto.getMinGrade(),
                dto.getMaxGrade(),
                dto.getExposure(),
                dto.getFavorableSeasons(),
                dto.getOrientations(),
                dto.getPhotoUrl(),
                dto.getThumbnailUrl()
        );
    }
}