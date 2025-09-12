package com.gretacvld.climb_jam_api.controllers;

import com.gretacvld.climb_jam_api.dtos.UserStatsDTO;
import com.gretacvld.climb_jam_api.services.UserStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/{userId}/stats")
public class UserStatsController {

    @Autowired
    private UserStatsService userStatsService;

    @GetMapping
    public ResponseEntity<UserStatsDTO> getUserStats(@PathVariable Long userId) {
        return ResponseEntity.ok(userStatsService.getUserStats(userId));
    }
}