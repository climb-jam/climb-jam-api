package com.gretacvld.climb_jam_api.services;

import com.gretacvld.climb_jam_api.dtos.RouteDTO;
import com.gretacvld.climb_jam_api.entities.Crag;
import com.gretacvld.climb_jam_api.entities.Route;
import com.gretacvld.climb_jam_api.exceptions.CragNotFoundException;
import com.gretacvld.climb_jam_api.exceptions.RouteNotFoundException;
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
        Crag crag = cragRepository.findById(dto.getCragId())
                .orElseThrow(() -> new CragNotFoundException("Site d'escalade introuvable avec l'ID " + dto.getCragId()));
        Route route = routeRepository.save(RouteMapper.toEntity(dto, crag));
        return RouteMapper.toDTO(route);
    }

    public List<RouteDTO> getAllRoutes() {
        return routeRepository.findAll().stream()
                .map(RouteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<RouteDTO> getRouteById(Long id) {
        return routeRepository.findById(id).map(RouteMapper::toDTO);
    }

    public List<RouteDTO> getRoutesByName(String name) {
        return routeRepository.findByNameContainingIgnoreCase(name).stream()
                .map(RouteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<RouteDTO> getRoutesByCragCoordinates(Double lat, Double lon) {
        return routeRepository.findByCragLatAndCragLon(lat, lon).stream()
                .map(RouteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        if (!routeRepository.existsById(id)) {
            throw new RouteNotFoundException("Voie introuvable avec l'ID " + id);
        }
        routeRepository.deleteById(id);
    }
}