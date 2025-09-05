package com.gretacvld.climb_jam_api.controllers;

import com.gretacvld.climb_jam_api.dtos.AdminRegisterDTO;
import com.gretacvld.climb_jam_api.dtos.AdminUserDTO;
import com.gretacvld.climb_jam_api.services.AdminUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/create")
    public ResponseEntity<AdminUserDTO> createAdmin(@Valid @RequestBody AdminRegisterDTO dto) {
        return ResponseEntity.ok(adminUserService.createAdmin(dto));
    }
}