package com.gretacvld.climb_jam_api.controllers;

import com.gretacvld.climb_jam_api.dtos.CragDTO;
import com.gretacvld.climb_jam_api.mappers.CragMapper;
import com.gretacvld.climb_jam_api.repositories.CragRepository;
import com.gretacvld.climb_jam_api.services.CragService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crags")
public class CragController {

    @Autowired
    private CragService cragService;

    @Autowired
    private CragRepository cragRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<CragDTO> createCrag(@Valid @RequestBody CragDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cragService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CragDTO> getCragById(@PathVariable Long id) {
        return cragService.getCragById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<CragDTO> getAllCrags() {
        return cragRepository.findAll()
                .stream()
                .map(CragMapper::toDTO)
                .toList();
    }

    @GetMapping("/search/gps") // ex: /search/gps?lat=48.678913&lon=2.152492
    public ResponseEntity<CragDTO> getByCoordinates(@RequestParam Double lat, @RequestParam Double lon) {
        return cragService.getCragByCoordinates(lat, lon).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<Page<CragDTO>> searchCrags(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(
                cragService.searchCrags(name, page, size)
        );
    }

    @GetMapping("/search/location")
    public ResponseEntity<List<CragDTO>> getCragsByCityOrPostalCode(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String postalCode
    ) {
        return ResponseEntity.ok(
                cragService.getCragsByCityOrPostalCode(city, postalCode)
        );
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CragDTO> update(@PathVariable Long id, @Valid @RequestBody CragDTO dto) {
        return ResponseEntity.ok(cragService.update(id, dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cragService.delete(id);
        return ResponseEntity.noContent().build();
    }
}