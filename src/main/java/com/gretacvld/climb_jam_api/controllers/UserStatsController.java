package com.gretacvld.climb_jam_api.controllers;

import com.gretacvld.climb_jam_api.dtos.UserStatsDTO;
import com.gretacvld.climb_jam_api.entities.User;
import com.gretacvld.climb_jam_api.helpers.Utils;
import com.gretacvld.climb_jam_api.services.UserStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class UserStatsController {

    @Autowired
    private UserStatsService userStatsService;

    @Autowired
    private Utils utils;

    @GetMapping("/me")
    public ResponseEntity<UserStatsDTO> getMyStats() {
        User user = utils.getCurrentUser();
        return ResponseEntity.ok(userStatsService.getUserStats(user.getId()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users/{userId}")
    public ResponseEntity<UserStatsDTO> getUserStats(@PathVariable Long userId) {
        return ResponseEntity.ok(userStatsService.getUserStats(userId));
    }
}