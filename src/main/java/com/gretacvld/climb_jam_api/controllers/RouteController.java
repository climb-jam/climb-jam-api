package com.gretacvld.climb_jam_api.controllers;

import com.gretacvld.climb_jam_api.dtos.CragDTO;
import com.gretacvld.climb_jam_api.dtos.RouteDTO;
import com.gretacvld.climb_jam_api.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping
    public ResponseEntity<RouteDTO> createRoute(@RequestBody RouteDTO dto) {
        return ResponseEntity.ok(routeService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<RouteDTO>> getAllRoutes() {
        return ResponseEntity.ok(routeService.getAllRoutes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteDTO> getRouteById(@PathVariable Long id) {
        return routeService.getRouteById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search/name/{name}") // ex: /search/name/viaduc
    public ResponseEntity<List<RouteDTO>> getRoutesByName(@PathVariable String name) {
        return ResponseEntity.ok(routeService.getRoutesByName(name));
    }

    @GetMapping("/search/gps")
    public ResponseEntity<List<RouteDTO>> getRoutesByCragCoordinates(@RequestParam Double lat, @RequestParam Double lon) {
        return ResponseEntity.ok(routeService.getRoutesByCragCoordinates(lat, lon));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        routeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}