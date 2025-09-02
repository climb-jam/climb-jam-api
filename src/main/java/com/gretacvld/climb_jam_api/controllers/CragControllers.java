package com.gretacvld.climb_jam_api.controllers;

import com.gretacvld.climb_jam_api.dtos.CragDTO;
import com.gretacvld.climb_jam_api.services.CragService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/crags")
public class CragControllers {

    @Autowired
    private CragService cragService;

    @GetMapping
    public ResponseEntity<List<CragDTO>> getAllCrags() {
        return ResponseEntity.ok(cragService.getAllCrags());
    }
}