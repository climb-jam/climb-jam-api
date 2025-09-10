package com.gretacvld.climb_jam_api.mappers;

import com.gretacvld.climb_jam_api.dtos.ProfileDTO;
import com.gretacvld.climb_jam_api.entities.Profile;
import com.gretacvld.climb_jam_api.entities.User;

public class ProfileMapper {

    // Entity Profile ==> ProfileDTO
    public static ProfileDTO toDTO(Profile profile) {
        if (profile == null) return null;
        ProfileDTO dto = new ProfileDTO();
        dto.setId(profile.getId());
        dto.setAvatarUrl(profile.getAvatarUrl());
        dto.setCity(profile.getCity());
        dto.setPostalCode(profile.getPostalCode());
        return dto;
    }

    // ProfileDTO ==> Entity Profile
    public static Profile toEntity(ProfileDTO dto, User user) {
        if (dto == null) return null;
        Profile profile = new Profile();
        profile.setUser(user);
        profile.setId(dto.getId());
        profile.setAvatarUrl(dto.getAvatarUrl());
        profile.setCity(dto.getCity());
        profile.setPostalCode(dto.getPostalCode());
        return profile;
    }
}