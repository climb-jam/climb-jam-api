package com.gretacvld.climb_jam_api.services;

import com.gretacvld.climb_jam_api.dtos.ProfileDTO;
import com.gretacvld.climb_jam_api.dtos.UserDTO;
import com.gretacvld.climb_jam_api.entities.Profile;
import com.gretacvld.climb_jam_api.entities.User;
import com.gretacvld.climb_jam_api.exceptions.ProfileNotFoundException;
import com.gretacvld.climb_jam_api.exceptions.UserNotFoundException;
import com.gretacvld.climb_jam_api.mappers.ProfileMapper;
import com.gretacvld.climb_jam_api.mappers.UserMapper;
import com.gretacvld.climb_jam_api.repositories.ProfileRepository;
import com.gretacvld.climb_jam_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Optional<ProfileDTO> getProfileById(Long id) {
        return profileRepository.findById(id)
                .map(ProfileMapper::toDTO);
    }

    public Optional<ProfileDTO> getProfileByUsername(String username) {
        return profileRepository.findByUserUsername(username)
                .map(ProfileMapper::toDTO);
    }

    public ProfileDTO create(Long userId, ProfileDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Utilisateur introuvable avec l'ID " + userId));
        Profile profile = ProfileMapper.toEntity(dto, user);
        Profile saved = profileRepository.save(profile);
        return ProfileMapper.toDTO(saved);
    }

    public ProfileDTO update(Long id, ProfileDTO dto) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("Profil introuvable avec l'ID " + id));
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
            throw new ProfileNotFoundException("Profil introuvable avec l'ID " + id);
        }
        profileRepository.deleteById(id);
    }
}