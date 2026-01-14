package com.gretacvld.climb_jam_api.controllers;

import com.gretacvld.climb_jam_api.dtos.ProfileDTO;
import com.gretacvld.climb_jam_api.entities.User;
import com.gretacvld.climb_jam_api.exceptions.UserNotFoundException;
import com.gretacvld.climb_jam_api.mappers.ProfileMapper;
import com.gretacvld.climb_jam_api.services.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/me")
    public ProfileDTO getMyProfile(@AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername();
        User user = profileService.getUserByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Utilisateur introuvable"));
        return ProfileMapper.toDTO(user.getProfile());
    }

    @PutMapping("/me")
    public ProfileDTO updateMyProfile(@AuthenticationPrincipal UserDetails userDetails, @Valid @RequestBody ProfileDTO dto) {
        String email = userDetails.getUsername();
        User user = profileService.getUserByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Utilisateur introuvable"));
        return profileService.update(user.getId(), dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/user/{userId}")
    public ResponseEntity<ProfileDTO> getProfileByUserId(@PathVariable Long userId) {
        return profileService.getProfileByUserId(userId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/user/{userId}")
    public ResponseEntity<ProfileDTO> updateProfileByUserId(@PathVariable Long userId, @Valid @RequestBody ProfileDTO dto) {
        return ResponseEntity.ok(profileService.update(userId, dto));
    }
}