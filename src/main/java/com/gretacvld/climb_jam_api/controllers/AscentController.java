package com.gretacvld.climb_jam_api.controllers;

import com.gretacvld.climb_jam_api.dtos.AscentDTO;
import com.gretacvld.climb_jam_api.entities.CustomUserDetails;
import com.gretacvld.climb_jam_api.services.AscentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ascents")
public class AscentController {

    @Autowired
    private AscentService ascentService;

    @GetMapping("/me") // Shows ascents of the connected user
    public ResponseEntity<List<AscentDTO>> getMyAscents(@AuthenticationPrincipal CustomUserDetails userDetails) {
        Long userId = userDetails.getId();
        return ResponseEntity.ok(ascentService.getAscentsByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<AscentDTO> createAscent(@RequestBody @Valid AscentDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ascentService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<AscentDTO>> getAllAscents() {
        return ResponseEntity.ok(ascentService.getAllAscents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AscentDTO> getAscentById(@PathVariable Long id) {
        return ascentService.getAscentById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AscentDTO>> getAscentsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(ascentService.getAscentsByUserId(userId));
    }

    @GetMapping("/route/{routeId}")
    public ResponseEntity<List<AscentDTO>> getAscentsByRoute(@PathVariable Long routeId) {
        return ResponseEntity.ok(ascentService.getAscentsByRouteId(routeId));
    }

    @GetMapping("/session/{sessionId}")
    public ResponseEntity<List<AscentDTO>> getAscentsBySession(@PathVariable Long sessionId) {
        return ResponseEntity.ok(ascentService.getAscentsBySessionId(sessionId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ascentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/comment")
    public ResponseEntity<AscentDTO> updateComment(@PathVariable Long id, @RequestBody String newComment) {
        return ResponseEntity.ok(ascentService.updateComment(id, newComment));
    }

    @DeleteMapping("/{id}/comment")
    public ResponseEntity<AscentDTO> deleteComment(@PathVariable Long id) {
        return ResponseEntity.ok(ascentService.deleteComment(id));
    }
}