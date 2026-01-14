package com.gretacvld.climb_jam_api.controllers;

import com.gretacvld.climb_jam_api.dtos.UserDTO;
import com.gretacvld.climb_jam_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/role-user")
    public ResponseEntity<List<UserDTO>> getAllUsersRoleUser() {
        return ResponseEntity.ok(userService.getAllUsersRoleUser());
    }
}