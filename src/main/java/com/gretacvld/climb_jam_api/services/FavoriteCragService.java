package com.gretacvld.climb_jam_api.services;

import com.gretacvld.climb_jam_api.dtos.CragDTO;
import com.gretacvld.climb_jam_api.dtos.FavoriteCragDTO;
import com.gretacvld.climb_jam_api.entities.Crag;
import com.gretacvld.climb_jam_api.entities.FavoriteCrag;
import com.gretacvld.climb_jam_api.entities.User;
import com.gretacvld.climb_jam_api.exceptions.CragNotFoundException;
import com.gretacvld.climb_jam_api.exceptions.FavoriteCragNotFoundException;
import com.gretacvld.climb_jam_api.helpers.Utils;
import com.gretacvld.climb_jam_api.mappers.CragMapper;
import com.gretacvld.climb_jam_api.mappers.FavoriteCragMapper;
import com.gretacvld.climb_jam_api.repositories.CragRepository;
import com.gretacvld.climb_jam_api.repositories.FavoriteCragRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteCragService {

    @Autowired
    private FavoriteCragRepository favoriteCragRepository;

    @Autowired
    private CragRepository cragRepository;

    @Autowired
    private Utils utils;


    public List<CragDTO> getMyFavorites() {
        User user = utils.getCurrentUser();

        return favoriteCragRepository.findByUserId(user.getId())
                .stream()
                .map(fav -> CragMapper.toDTO(fav.getCrag()))
                .toList();
    }


    public FavoriteCragDTO addFavorite(Long cragId) {

        User user = utils.getCurrentUser();

        Crag crag = cragRepository.findById(cragId)
                .orElseThrow(() ->
                        new CragNotFoundException("Site d'escalade introuvable"));

        if (favoriteCragRepository.existsByUserIdAndCragId(user.getId(), cragId)) {
            throw new IllegalStateException("Ce site est déjà dans vos favoris");
        }

        FavoriteCrag favorite = new FavoriteCrag();
        favorite.setUser(user);
        favorite.setCrag(crag);

        return FavoriteCragMapper.toDTO(
                favoriteCragRepository.save(favorite)
        );
    }


    public void removeFavorite(Long cragId) {

        User user = utils.getCurrentUser();

        FavoriteCrag favorite = favoriteCragRepository
                .findByUserIdAndCragId(user.getId(), cragId)
                .orElseThrow(() ->
                        new FavoriteCragNotFoundException(
                                "Favori introuvable pour ce site"
                        ));

        favoriteCragRepository.delete(favorite);
    }

    public boolean isFavorite(Long cragId) {

        User user = utils.getCurrentUser();

        return favoriteCragRepository
                .existsByUserIdAndCragId(user.getId(), cragId);
    }
}