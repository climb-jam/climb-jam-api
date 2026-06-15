package com.gretacvld.climb_jam_api.services;

import com.gretacvld.climb_jam_api.dtos.*;
import com.gretacvld.climb_jam_api.entities.User;
import com.gretacvld.climb_jam_api.exceptions.EmailAlreadyUsedException;
import com.gretacvld.climb_jam_api.exceptions.InvalidLoginInfoException;
import com.gretacvld.climb_jam_api.exceptions.UsernameAlreadyUsedException;
import com.gretacvld.climb_jam_api.exceptions.UsernameNotFoundException;
import com.gretacvld.climb_jam_api.mappers.UserMapper;
import com.gretacvld.climb_jam_api.repositories.UserRepository;
import com.gretacvld.climb_jam_api.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthResponseDTO register(RegisterRequestDTO dto) {

        // Checks if email already exists
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new EmailAlreadyUsedException("L'email est déjà utilisé !");
        }

        // Checks if username already exists
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new UsernameAlreadyUsedException("Le nom d'utilisateur est déjà utilisé !");
        }
        // Checks if term accepted
        if (dto.getTermsAccepted() == null || !dto.getTermsAccepted()) {
            throw new IllegalArgumentException(
                    "Vous devez accepter les conditions d'utilisation."
            );
        }

        // Registers new user
        User user = UserMapper.toEntity(dto, encoder);
        // Save in DB
        User savedUser = userRepository.save(user);
        // Generates JWT
        String token = jwtUtil.generateToken(savedUser.getEmail());

        return new AuthResponseDTO(UserMapper.toDTO(savedUser), token);
    }

    public AuthResponseDTO login(LoginRequestDTO dto) {

        // Authentification via Spring Security
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                            dto.getEmail(),
                            dto.getPassword()
                )
            );

        // Retrieves user from DB
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable"));
        // Checks login info
        if (!encoder.matches(dto.getPassword(), user.getPassword())) {
            throw new InvalidLoginInfoException("Identifiants incorrects");

        }
        // Generates JWT
        String token = jwtUtil.generateToken(dto.getEmail());

        // Returns AuthResponseDTO (user + token)
        return new AuthResponseDTO(
                UserMapper.toDTO(user),
                token
        );
    }
}