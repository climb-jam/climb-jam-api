package com.gretacvld.climb_jam_api.mappers;

import com.gretacvld.climb_jam_api.dtos.RouteDTO;
import com.gretacvld.climb_jam_api.entities.Crag;
import com.gretacvld.climb_jam_api.entities.Route;

public class RouteMapper {

    // Entity Route ==> RouteDTO
    public static RouteDTO toDTO(Route route) {
        RouteDTO dto = new RouteDTO();
        dto.setCragId(route.getCrag().getId());
        dto.setName(route.getName());
        dto.setClimbingTypes(route.getClimbingTypes());
        dto.setGrade(route.getGrade());
        dto.setHeight(route.getHeight());
        dto.setInclineType(route.getInclineType());
        dto.setAnchorType(route.getAnchorType());
        dto.setBoltType(route.getBoltType());
        dto.setBoltCount(route.getBoltCount());
        dto.setSector(route.getSector());
        return dto;
    }

    // RouteDTO ==> Entity Route
    public static Route toEntity(RouteDTO dto, Crag crag) {
        Route route = new Route();
        route.setId(dto.getId());
        route.setCrag(crag);
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