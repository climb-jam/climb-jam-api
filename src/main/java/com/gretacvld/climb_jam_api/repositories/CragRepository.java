package com.gretacvld.climb_jam_api.repositories;

import com.gretacvld.climb_jam_api.entities.Crag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface CragRepository extends JpaRepository<Crag, Long> {
    Page<Crag> findAll(Pageable pageable);
    Page<Crag> findByNameContainingIgnoreCase(String name, Pageable pageable);
    List<Crag> findByNameContainingIgnoreCase(String name);
    Optional<Crag> findByLatAndLon(Double lat, Double lon);
    List<Crag> findByCityContainingIgnoreCaseOrPostalCodeContainingIgnoreCase(String city, String postalCode);

}