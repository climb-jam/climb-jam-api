package com.gretacvld.climb_jam_api.mappers;

import com.gretacvld.climb_jam_api.dtos.AscentDTO;
import com.gretacvld.climb_jam_api.entities.Ascent;

public class AscentMapper {

    // Entity Ascent ==> AscentDTO
    public static AscentDTO toDTO(Ascent ascent) {
        if (ascent == null) return null;
        return new AscentDTO(
                ascent.getId(),
                UserMapper.toDTO(ascent.getUser()),
                RouteMapper.toDTO(ascent.getRoute()),
                SessionMapper.toDTO(ascent.getSession()),
                ascent.getDate(),
                ascent.getStyle(),
                ascent.getTries(),
                ascent.getComment()
        );
    }

    // AscentDTO ==> Entity Ascent
    public static Ascent toEntity(AscentDTO dto) {
        if (dto == null) return null;
        Ascent ascent = new Ascent();
        ascent.setId(dto.getId());
        ascent.setUser(UserMapper.toEntity(dto.getUser()));
        ascent.setRoute(RouteMapper.toEntity(dto.getRoute()));
        ascent.setSession(SessionMapper.toEntity(dto.getSession()));
        ascent.setDate(dto.getDate());
        ascent.setStyle(dto.getStyle());
        ascent.setTries(dto.getTries());
        ascent.setComment(dto.getComment());
        return ascent;
    }
}