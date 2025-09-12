package com.gretacvld.climb_jam_api.repositories;

import com.gretacvld.climb_jam_api.entities.Ascent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AscentRepository extends JpaRepository<Ascent, Long> {

    List<Ascent> findByUserId(Long userId);
    List<Ascent> findByRouteId(Long routeId);
    List<Ascent> findBySessionId(Long sessionId);

    long countByUserId(Long userId);
}