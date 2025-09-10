package com.gretacvld.climb_jam_api.mappers;

import com.gretacvld.climb_jam_api.dtos.CragDTO;
import com.gretacvld.climb_jam_api.entities.Crag;

public class CragMapper {

    // Entity Crag ==> DTO CragDTO
    public static CragDTO toDTO(Crag crag) {
        if (crag == null) return null;
        return new CragDTO(
                crag.getId(),
                crag.getName(),
                crag.getCity(),
                crag.getPostalCode(),
                crag.getLat(),
                crag.getLon(),
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
        if (dto == null) return null;
        return new Crag(
                dto.getId(),
                dto.getName(),
                dto.getCity(),
                dto.getPostalCode(),
                dto.getLat(),
                dto.getLon(),
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