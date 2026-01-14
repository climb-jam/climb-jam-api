package com.gretacvld.climb_jam_api.services;

import com.gretacvld.climb_jam_api.dtos.AdminRegisterDTO;
import com.gretacvld.climb_jam_api.dtos.AdminUserDTO;
import com.gretacvld.climb_jam_api.entities.User;
import com.gretacvld.climb_jam_api.enums.Role;
import com.gretacvld.climb_jam_api.exceptions.EmailAlreadyUsedException;
import com.gretacvld.climb_jam_api.exceptions.UsernameAlreadyUsedException;
import com.gretacvld.climb_jam_api.mappers.AdminUserMapper;
import com.gretacvld.climb_jam_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AdminUserMapper adminUserMapper;

    public AdminUserDTO createAdmin(AdminRegisterDTO dto) {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new EmailAlreadyUsedException("L'email est déjà utilisé !");
        }

        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new UsernameAlreadyUsedException("Le nom d'utilisateur est déjà utilisé !");
        }

        User admin = adminUserMapper.toEntity(dto, encoder);
        admin.setRole(Role.ADMIN);

        User savedAdmin = userRepository.save(admin);
        return adminUserMapper.toDTO(savedAdmin);
    }
}