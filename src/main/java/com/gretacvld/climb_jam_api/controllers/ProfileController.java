package com.gretacvld.climb_jam_api.controllers;

import com.gretacvld.climb_jam_api.dtos.CragDTO;
import com.gretacvld.climb_jam_api.dtos.ProfileDTO;
import com.gretacvld.climb_jam_api.services.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;


    @GetMapping
    public ResponseEntity<List<ProfileDTO>> getAllProfiles() {
        return ResponseEntity.ok(profileService.getAllProfiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDTO> getById(@PathVariable Long id) {
        return profileService.getProfileById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{username}") // ex: /search/gps?lat=48.678913&lon=2.152492
    public ResponseEntity<ProfileDTO> getByUsername(@RequestParam String username) {
        return profileService.getProfileByUsername(username).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<ProfileDTO> create(@PathVariable Long userId, @Valid @RequestBody ProfileDTO dto) {
        return ResponseEntity.ok(profileService.create(userId, dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileDTO> update(@PathVariable Long id, @Valid @RequestBody ProfileDTO dto) {
        return ResponseEntity.ok(profileService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        profileService.delete(id);
        return ResponseEntity.noContent().build();
    }
}