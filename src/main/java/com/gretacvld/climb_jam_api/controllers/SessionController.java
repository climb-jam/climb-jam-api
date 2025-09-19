package com.gretacvld.climb_jam_api.controllers;

import com.gretacvld.climb_jam_api.dtos.SessionDTO;
import com.gretacvld.climb_jam_api.entities.CustomUserDetails;
import com.gretacvld.climb_jam_api.services.SessionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/me") // Shows sessions of the connected user
    public ResponseEntity<List<SessionDTO>> getMySessions(@AuthenticationPrincipal CustomUserDetails userDetails) {
        Long userId = userDetails.getId();
        return ResponseEntity.ok(sessionService.getSessionsByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<SessionDTO> createSession(@RequestBody @Valid SessionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sessionService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<SessionDTO>> getAllSessions() {
        return ResponseEntity.ok(sessionService.getAllSessions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionDTO> getSessionById(@PathVariable Long id) {
        return sessionService.getSessionById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SessionDTO>> getSessionsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(sessionService.getSessionsByUserId(userId));
    }

    @GetMapping("/crag/{cragId}")
    public ResponseEntity<List<SessionDTO>> getSessionsByCrag(@PathVariable Long cragId) {
        return ResponseEntity.ok(sessionService.getSessionsByCragId(cragId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SessionDTO> update(@PathVariable Long id, @Valid @RequestBody SessionDTO dto) {
        return ResponseEntity.ok(sessionService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        sessionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}