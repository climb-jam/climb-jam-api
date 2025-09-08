package com.gretacvld.climb_jam_api.repositories;

import com.gretacvld.climb_jam_api.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {

    List<Route> findByNameContainingIgnoreCase(String name);
    List<Route> findByCragLatAndCragLon(Double lat, Double lon);
}