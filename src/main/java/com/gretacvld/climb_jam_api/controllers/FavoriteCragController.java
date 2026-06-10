package com.gretacvld.climb_jam_api.controllers;

import com.gretacvld.climb_jam_api.dtos.CragDTO;
import com.gretacvld.climb_jam_api.dtos.FavoriteCragDTO;
import com.gretacvld.climb_jam_api.services.FavoriteCragService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoriteCragController {

    @Autowired
    private FavoriteCragService favoriteCragService;

    @GetMapping
    public ResponseEntity<List<CragDTO>> getMyFavorites() {
        return ResponseEntity.ok(favoriteCragService.getMyFavorites());
    }


    @PostMapping("/{cragId}")
    public ResponseEntity<FavoriteCragDTO> addFavorite(
            @PathVariable Long cragId) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(favoriteCragService.addFavorite(cragId));
    }


    @DeleteMapping("/{cragId}")
    public ResponseEntity<Void> removeFavorite(
            @PathVariable Long cragId) {

        favoriteCragService.removeFavorite(cragId);

        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{cragId}/status")
    public ResponseEntity<Boolean> isFavorite(
            @PathVariable Long cragId) {

        return ResponseEntity.ok(
                favoriteCragService.isFavorite(cragId)
        );
    }
}