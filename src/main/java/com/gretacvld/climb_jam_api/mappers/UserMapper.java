package com.gretacvld.climb_jam_api.mappers;

import com.gretacvld.climb_jam_api.dtos.RegisterRequestDTO;
import com.gretacvld.climb_jam_api.dtos.UserResponseDTO;
import com.gretacvld.climb_jam_api.entities.User;
import com.gretacvld.climb_jam_api.enums.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component // Needs to be a Spring bean with @Component cause it needs injection(PasswordEncoder)
public class UserMapper {

    // User Entity ==> UserResponseDTO
    public UserResponseDTO toDTO(User user) {
        if (user == null) return null;
        return new UserResponseDTO(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                user.getRole(),
                user.getCreatedAt()
        );
    }

    // RegisterRequestDTO ==> User Entity
    public User toEntity(RegisterRequestDTO dto, PasswordEncoder encoder) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setUsername(dto.getUsername());
        user.setRole(Role.USER);
        return user;
    }
}