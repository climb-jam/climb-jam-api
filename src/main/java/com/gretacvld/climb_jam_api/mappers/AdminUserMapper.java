package com.gretacvld.climb_jam_api.mappers;

import com.gretacvld.climb_jam_api.dtos.AdminRegisterDTO;
import com.gretacvld.climb_jam_api.dtos.AdminUserDTO;
import com.gretacvld.climb_jam_api.entities.User;
import com.gretacvld.climb_jam_api.enums.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminUserMapper {

    // User Entity ==> AdminUserDTO
    public AdminUserDTO toDTO(User user) {
        AdminUserDTO dto = new AdminUserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole());
        return dto;
    }

    // AdminUserDTO ==> User Entity
    public User toEntity(AdminRegisterDTO dto, PasswordEncoder encoder) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setUsername(dto.getUsername());
        user.setRole(Role.ADMIN);
        return user;
    }
}