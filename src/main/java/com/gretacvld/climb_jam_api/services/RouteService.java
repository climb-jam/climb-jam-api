package com.gretacvld.climb_jam_api.services;

import com.gretacvld.climb_jam_api.dtos.CragDTO;
import com.gretacvld.climb_jam_api.dtos.RouteDTO;
import com.gretacvld.climb_jam_api.entities.Crag;
import com.gretacvld.climb_jam_api.entities.Route;
import com.gretacvld.climb_jam_api.exceptions.CragNotFoundException;
import com.gretacvld.climb_jam_api.exceptions.RouteNotFoundException;
import com.gretacvld.climb_jam_api.mappers.CragMapper;
import com.gretacvld.climb_jam_api.mappers.RouteMapper;
import com.gretacvld.climb_jam_api.repositories.CragRepository;
import com.gretacvld.climb_jam_api.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private CragRepository cragRepository;

    public RouteDTO create(RouteDTO dto) {
        Crag crag = cragRepository.findById(dto.getCrag().getId())
                .orElseThrow(() -> new CragNotFoundException("Site d'escalade introuvable"));
        Route route = RouteMapper.toEntity(dto);
        route.setCrag(crag);
        return RouteMapper.toDTO(routeRepository.save(route));
    }

    public List<RouteDTO> getAllRoutes() {
        return routeRepository.findAll().stream()
                .map(RouteMapper::toDTO)
                .collect(Collectors.toList());
    }



    public List<RouteDTO> getRoutesByCragId(Long crag_id) {
        return routeRepository.findByCragId(crag_id).stream()
                .map(RouteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<RouteDTO> getRouteByName(String name) {
        return routeRepository.findByNameContainingIgnoreCase(name).stream()
                .map(RouteMapper::toDTO).collect(Collectors.toList());
    }
    public Optional<RouteDTO> getRouteById(Long id) {
        return routeRepository.findById(id)
                .map(RouteMapper::toDTO);
    }

    public List<RouteDTO> getRoutesByCragCoordinates(Double lat, Double lon) {
        return routeRepository.findByCragLatAndCragLon(lat, lon).stream()
                .map(RouteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RouteDTO update(Long id, RouteDTO dto) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new RouteNotFoundException("Voie introuvable avec l'ID " + id));
        route.setName(dto.getName());
        route.setClimbingTypes(dto.getClimbingTypes());
        route.setGrade(dto.getGrade());
        route.setHeight(dto.getHeight());
        route.setInclineType(dto.getInclineType());
        route.setAnchorType(dto.getAnchorType());
        route.setBoltType(dto.getBoltType());
        route.setBoltCount(dto.getBoltCount());
        route.setSector(dto.getSector());
        return RouteMapper.toDTO(routeRepository.save(route));
    }

    public void delete(Long id) {
        if (!routeRepository.existsById(id)) {
            throw new RouteNotFoundException("Voie introuvable avec l'ID " + id);
        }
        routeRepository.deleteById(id);
    }
}