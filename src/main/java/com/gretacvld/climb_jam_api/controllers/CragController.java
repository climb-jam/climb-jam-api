package com.gretacvld.climb_jam_api.controllers;

import com.gretacvld.climb_jam_api.dtos.CragDTO;
import com.gretacvld.climb_jam_api.services.CragService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crags")
public class CragController {

    @Autowired
    private CragService cragService;

    @PostMapping
    public ResponseEntity<CragDTO> createCrag(@Valid @RequestBody CragDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cragService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CragDTO> getCragById(@PathVariable Long id) {
        return cragService.getCragById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<CragDTO>> getAllCrags() {
        return ResponseEntity.ok(cragService.getCragWithFav());
    }

    @GetMapping
    public ResponseEntity<Page<CragDTO>> getAllCragsPaginate(
            @PageableDefault(size = 6, sort = "name") Pageable pageable
    ) {
        return ResponseEntity.ok(cragService.getAllPaginated(pageable));
    }

    @GetMapping("/search/gps") // ex: /search/gps?lat=48.678913&lon=2.152492
    public ResponseEntity<CragDTO> getByCoordinates(@RequestParam Double lat, @RequestParam Double lon) {
        return cragService.getCragByCoordinates(lat, lon).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping(value = "/search", params = "name")
    public ResponseEntity<Page<CragDTO>> searchCragsByName(
            @RequestParam String name,
            @PageableDefault(size = 6, sort = "name") Pageable pageable
    ) {
        Page<CragDTO> crags = cragService.getCragsByNamePaginated(name, pageable);
        return ResponseEntity.ok(crags);
    }

    @GetMapping("/search") // Different ways to call endpoint - ex : /search?city=saf OR /search?postalCode=21 OR /search?city=saf&postalCode=21
    public ResponseEntity<List<CragDTO>> getCragsByCityOrPostalCode(@RequestParam(required = false) String city, @RequestParam(required = false) String postalCode) {
        return ResponseEntity.ok(cragService.getCragsByCityOrPostalCode(city, postalCode));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CragDTO> update(@PathVariable Long id, @Valid @RequestBody CragDTO dto) {
        return ResponseEntity.ok(cragService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cragService.delete(id);
        return ResponseEntity.noContent().build();
    }
}