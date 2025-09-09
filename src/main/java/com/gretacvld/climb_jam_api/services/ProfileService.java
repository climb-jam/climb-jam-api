package com.gretacvld.climb_jam_api.services;

import com.gretacvld.climb_jam_api.dtos.ProfileDTO;
import com.gretacvld.climb_jam_api.entities.Profile;
import com.gretacvld.climb_jam_api.entities.User;
import com.gretacvld.climb_jam_api.exceptions.ProfileNotFoundException;
import com.gretacvld.climb_jam_api.mappers.ProfileMapper;
import com.gretacvld.climb_jam_api.repositories.ProfileRepository;
import com.gretacvld.climb_jam_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private UserRepository userRepository;

    public List<ProfileDTO> getAllProfiles() {
        return profileRepository.findAll().stream()
                .map(ProfileMapper::toDTO).collect(Collectors.toList());
    }

    public ProfileDTO create(ProfileDTO dto) {
        Profile profile = ProfileMapper.toEntity(dto);
        // If DTO has a userId, fetches User from DB and sets it in Profile entity
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId()).orElse(null);
            profile.setUser(user);
        }
        // Saves entity in the DB
        Profile saved = profileRepository.save(profile);
        // Converts saved entity back into a DTO
        return ProfileMapper.toDTO(saved);
    }

    public ProfileDTO update(Long id, ProfileDTO dto) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("Profile introuvable avec l'ID " + id));
        profile.setAvatarUrl(dto.getAvatarUrl());
        profile.setCity(dto.getCity());
        profile.setPostalCode(dto.getPostalCode());
        if (dto.getUserId() != null) {
            userRepository.findById(dto.getUserId()).ifPresent(profile::setUser);
        }
        Profile saved = profileRepository.save(profile);
        return ProfileMapper.toDTO(saved);
    }

    public void delete(Long id) {
        if (!profileRepository.existsById(id)) {
            throw new ProfileNotFoundException("Profile introuvable avec l'ID " + id);
        }
        profileRepository.deleteById(id);
    }
}