package com.gretacvld.climb_jam_api.mappers;

import com.gretacvld.climb_jam_api.dtos.RouteDTO;
import com.gretacvld.climb_jam_api.entities.Route;

public class RouteMapper {

    // Entity Route ==> RouteDTO
    public static RouteDTO toDTO(Route route) {
        if (route == null) return null;
        return new RouteDTO(
                route.getId(),
                CragMapper.toDTO(route.getCrag()),
                route.getName(),
                route.getClimbingTypes(),
                route.getGrade(),
                route.getHeight(),
                route.getInclineType(),
                route.getAnchorType(),
                route.getBoltType(),
                route.getBoltCount(),
                route.getSector()
        );
    }

    // RouteDTO ==> Entity Route
    public static Route toEntity(RouteDTO dto) {
        if (dto == null) return null;
        Route route = new Route();
        route.setId(dto.getId());
        route.setCrag(CragMapper.toEntity(dto.getCrag()));
        route.setName(dto.getName());
        route.setClimbingTypes(dto.getClimbingTypes());
        route.setGrade(dto.getGrade());
        route.setHeight(dto.getHeight());
        route.setInclineType(dto.getInclineType());
        route.setAnchorType(dto.getAnchorType());
        route.setBoltType(dto.getBoltType());
        route.setBoltCount(dto.getBoltCount());
        route.setSector(dto.getSector());
        return route;
    }
}