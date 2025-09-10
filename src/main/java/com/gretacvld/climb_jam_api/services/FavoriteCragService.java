package com.gretacvld.climb_jam_api.services;

import com.gretacvld.climb_jam_api.dtos.FavoriteCragDTO;
import com.gretacvld.climb_jam_api.entities.Crag;
import com.gretacvld.climb_jam_api.entities.FavoriteCrag;
import com.gretacvld.climb_jam_api.entities.User;
import com.gretacvld.climb_jam_api.exceptions.CragNotFoundException;
import com.gretacvld.climb_jam_api.exceptions.FavoriteCragNotFoundException;
import com.gretacvld.climb_jam_api.exceptions.UserNotFoundException;
import com.gretacvld.climb_jam_api.mappers.FavoriteCragMapper;
import com.gretacvld.climb_jam_api.repositories.CragRepository;
import com.gretacvld.climb_jam_api.repositories.FavoriteCragRepository;
import com.gretacvld.climb_jam_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoriteCragService {

    @Autowired
    private FavoriteCragRepository favoriteCragRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CragRepository cragRepository;

    public List<FavoriteCragDTO> getAllFavoriteCrags() {
        return favoriteCragRepository.findAll().stream()
                .map(FavoriteCragMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<FavoriteCragDTO> getFavoriteCragById(Long id) {
        return favoriteCragRepository.findById(id).map(FavoriteCragMapper::toDTO);
    }

    public List<FavoriteCragDTO> getFavoriteCragsByUserId(Long userId) {
        return favoriteCragRepository.findByUserId(userId).stream()
                .map(FavoriteCragMapper::toDTO)
                .collect(Collectors.toList());
    }

    public FavoriteCragDTO create(FavoriteCragDTO dto) {
        User user = userRepository.findById(dto.getUser().getId())
                .orElseThrow(() -> new UserNotFoundException("Utilisateur introuvable"));
        Crag crag = cragRepository.findById(dto.getCrag().getId())
                .orElseThrow(() -> new CragNotFoundException("Site d'escalade introuvable"));
        FavoriteCrag favorite = FavoriteCragMapper.toEntity(dto);
        favorite.setUser(user);
        favorite.setCrag(crag);
        return FavoriteCragMapper.toDTO(favoriteCragRepository.save(favorite));
    }

    public void delete(Long id) {
        if (!favoriteCragRepository.existsById(id)) {
            throw new FavoriteCragNotFoundException("Favori introuvable avec l'ID " + id);
        }
        favoriteCragRepository.deleteById(id);
    }
}