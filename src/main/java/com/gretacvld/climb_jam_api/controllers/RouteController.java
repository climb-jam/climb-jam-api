package com.gretacvld.climb_jam_api.controllers;

import com.gretacvld.climb_jam_api.dtos.RouteDTO;
import com.gretacvld.climb_jam_api.services.RouteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<RouteDTO> createRoute(@Valid @RequestBody RouteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(routeService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<RouteDTO>> getAllRoutes() {
        return ResponseEntity.ok(routeService.getAllRoutes());
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<List<RouteDTO>> getRouteByName(@PathVariable String name) {
        return ResponseEntity.ok(routeService.getRouteByName(name));
    }

    @GetMapping("/{crag_id}")
    public ResponseEntity<List<RouteDTO>> getRoutesByCragId(@PathVariable Long crag_id) {
        return ResponseEntity.ok(routeService.getRoutesByCragId(crag_id));
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<RouteDTO> getRouteById(@PathVariable Long id) {
        return routeService.getRouteById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

/*    @GetMapping("/search")
    public ResponseEntity<List<RouteDTO>> getRoutesByName(@RequestParam String name) {
        return ResponseEntity.ok(routeService.getRoutesByName(name));
    }*/

    @GetMapping("/gps")
    public ResponseEntity<List<RouteDTO>> getRoutesByCragCoordinates(@RequestParam Double lat, @RequestParam Double lon) {
        return ResponseEntity.ok(routeService.getRoutesByCragCoordinates(lat, lon));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<RouteDTO> update(@PathVariable Long id, @Valid @RequestBody RouteDTO dto) {
        return ResponseEntity.ok(routeService.update(id, dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        routeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}