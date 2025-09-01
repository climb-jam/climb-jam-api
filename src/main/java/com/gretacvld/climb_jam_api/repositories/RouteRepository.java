package com.gretacvld.climb_jam_api.repositories;

import com.gretacvld.climb_jam_api.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {

    List<Route> findByName(String name);
    List<Route> findByCragLatitudeAndCragLongitude(BigDecimal latitude, BigDecimal longitude);
}
