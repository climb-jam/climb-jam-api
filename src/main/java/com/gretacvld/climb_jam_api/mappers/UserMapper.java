package com.gretacvld.climb_jam_api.mappers;

import com.gretacvld.climb_jam_api.dtos.RegisterRequestDTO;
import com.gretacvld.climb_jam_api.dtos.UserDTO;
import com.gretacvld.climb_jam_api.entities.Profile;
import com.gretacvld.climb_jam_api.entities.User;
import com.gretacvld.climb_jam_api.enums.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component // Needs to be a Spring bean with @Component cause it needs injection(PasswordEncoder)
public class UserMapper {

    // User Entity ==> UserDTO
    public static UserDTO toDTO(User user) {
        if (user == null) return null;
        return new UserDTO(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                user.getRole(),
                user.getCreatedAt(),
                ProfileMapper.toDTO(user.getProfile())
        );
    }

    // RegisterRequestDTO ==> User Entity
    public static User toEntity(RegisterRequestDTO dto, PasswordEncoder encoder) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setUsername(dto.getUsername());
        user.setRole(Role.USER);
        user.setCreatedAt(Instant.now());

        // Creates a default empty profile
        Profile profile = new Profile();
        profile.setUser(user);
        profile.setAvatarUrl(null);
        profile.setCity(null);
        profile.setPostalCode(""); // Obligatoire
        user.setProfile(profile);

        return user;
    }

    // UserDTO ==> User Entity
    public static User toEntity(UserDTO dto) {
        if (dto == null) return null;
        User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setRole(dto.getRole());
        user.setCreatedAt(dto.getCreatedAt());
        if(dto.getProfile() != null) {
            user.setProfile(ProfileMapper.toEntity(dto.getProfile(), user));
        }
        return user;
    }
}