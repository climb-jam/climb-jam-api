package com.gretacvld.climb_jam_api.mappers;

import com.gretacvld.climb_jam_api.dtos.FavoriteCragDTO;
import com.gretacvld.climb_jam_api.entities.FavoriteCrag;

public class FavoriteCragMapper {

    // Entity FavoriteCrag ==> DTO FavoriteCragDTO
    public static FavoriteCragDTO toDTO(FavoriteCrag favoriteCrag) {
        if (favoriteCrag == null) return null;
        return new FavoriteCragDTO(
                favoriteCrag.getId(),
                UserMapper.toDTO(favoriteCrag.getUser()),
                CragMapper.toDTO(favoriteCrag.getCrag())
        );
    }

    // DTO FavoriteCragDTO ==> Entity FavoriteCrag
    public static FavoriteCrag toEntity(FavoriteCragDTO dto) {
        if (dto == null) return null;
        FavoriteCrag favorite = new FavoriteCrag();
        favorite.setId(dto.getId());
        favorite.setUser(UserMapper.toEntity(dto.getUser()));
        favorite.setCrag(CragMapper.toEntity(dto.getCrag()));
        return favorite;
    }
}