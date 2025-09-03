package com.gretacvld.climb_jam_api.repositories;

import com.gretacvld.climb_jam_api.entities.Crag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CragRepository extends JpaRepository<Crag, Long> {

    List<Crag> findByNameContainingIgnoreCase(String name);
    Optional<Crag> findByLatAndLon(Double lat, Double lon);
    List<Crag> findByCityContainingIgnoreCaseOrPostalCodeContainingIgnoreCase(String city, String postalCode);
}