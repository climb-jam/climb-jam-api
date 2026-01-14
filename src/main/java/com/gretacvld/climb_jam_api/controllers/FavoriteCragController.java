package com.gretacvld.climb_jam_api.controllers;

import com.gretacvld.climb_jam_api.dtos.FavoriteCragDTO;
import com.gretacvld.climb_jam_api.services.FavoriteCragService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoriteCragController {

    @Autowired
    private FavoriteCragService favoriteCragService;

    @GetMapping("/me")
    public ResponseEntity<List<FavoriteCragDTO>> getMyFavorites() {
        return ResponseEntity.ok(favoriteCragService.getMyFavorites());
    }

    @PostMapping
    public ResponseEntity<FavoriteCragDTO> createFavoriteCrag(@RequestBody @Valid FavoriteCragDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(favoriteCragService.create(dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<FavoriteCragDTO>> getAllFavoriteCrags() {
        return ResponseEntity.ok(favoriteCragService.getAllFavoriteCrags());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FavoriteCragDTO> getFavoriteCragById(@PathVariable Long id) {
        return favoriteCragService.getFavoriteCragById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FavoriteCragDTO>> getFavoriteCragsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(favoriteCragService.getFavoriteCragsByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        favoriteCragService.delete(id);
        return ResponseEntity.noContent().build();
    }
}