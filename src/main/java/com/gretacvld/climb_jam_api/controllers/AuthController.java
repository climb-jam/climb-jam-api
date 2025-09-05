package com.gretacvld.climb_jam_api.controllers;

import com.gretacvld.climb_jam_api.dtos.LoginRequestDTO;
import com.gretacvld.climb_jam_api.dtos.AuthResponseDTO;
import com.gretacvld.climb_jam_api.dtos.RegisterRequestDTO;
import com.gretacvld.climb_jam_api.dtos.UserResponseDTO;
import com.gretacvld.climb_jam_api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody RegisterRequestDTO dto) {
        return ResponseEntity.ok(userService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody LoginRequestDTO dto) {
        return ResponseEntity.ok(userService.login(dto));
    }
}