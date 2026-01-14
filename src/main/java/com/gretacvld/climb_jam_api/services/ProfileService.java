package com.gretacvld.climb_jam_api.services;

import com.gretacvld.climb_jam_api.dtos.ProfileDTO;
import com.gretacvld.climb_jam_api.entities.Profile;
import com.gretacvld.climb_jam_api.entities.User;
import com.gretacvld.climb_jam_api.exceptions.UserNotFoundException;
import com.gretacvld.climb_jam_api.mappers.ProfileMapper;
import com.gretacvld.climb_jam_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public ProfileDTO update(Long userId, ProfileDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Utilisateur introuvable avec l'ID " + userId));
        Profile profile = user.getProfile();
        if(profile == null) {
            profile = new Profile();
            profile.setUser(user);
            user.setProfile(profile);
        }
        profile.setAvatarUrl(dto.getAvatarUrl());
        profile.setCity(dto.getCity());
        profile.setPostalCode(dto.getPostalCode());
        userRepository.save(user);
        return ProfileMapper.toDTO(profile);
    }

    public Optional<ProfileDTO> getProfileByUserId(Long userId) {
        return userRepository.findById(userId)
                .map(User::getProfile)
                .map(ProfileMapper::toDTO);
    }
}