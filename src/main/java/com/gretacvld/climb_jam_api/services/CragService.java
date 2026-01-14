package com.gretacvld.climb_jam_api.services;

import com.gretacvld.climb_jam_api.dtos.CragDTO;
import com.gretacvld.climb_jam_api.dtos.FavoriteCragDTO;
import com.gretacvld.climb_jam_api.entities.Crag;
import com.gretacvld.climb_jam_api.entities.FavoriteCrag;
import com.gretacvld.climb_jam_api.entities.User;
import com.gretacvld.climb_jam_api.exceptions.CragNotFoundException;
import com.gretacvld.climb_jam_api.helpers.Utils;
import com.gretacvld.climb_jam_api.mappers.CragMapper;
import com.gretacvld.climb_jam_api.repositories.CragRepository;
import com.gretacvld.climb_jam_api.repositories.FavoriteCragRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CragService {

    @Autowired
    private CragRepository cragRepository;

    @Autowired
    private FavoriteCragRepository favoriteCragRepository;

    @Autowired
    Utils utils;

    public CragDTO create(CragDTO dto) {
        Crag crag = CragMapper.toEntity(dto);
        return CragMapper.toDTO(cragRepository.save(crag));
    }

    public List<CragDTO> getCragWithFav() {

        List<CragDTO> crags = getAllCrags();
        User user = utils.getCurrentUser();
        List<FavoriteCrag> favorisCrags = favoriteCragRepository.findByUserId(user.getId());
        crags.forEach(crag -> {
            Boolean isfavoris = favorisCrags.stream().anyMatch(favoriteCrag -> Objects.equals(favoriteCrag.getCrag().getId(), crag.getId()));
            System.out.println( "my logs : "+ "\u001B[34m " + isfavoris + " \u001B[0m");
            crag.setIsFav(isfavoris);
        });
        //TODO hydrater les crags


        return crags;
    }

    public Optional<CragDTO> getCragById(Long id) {
        return cragRepository.findById(id)
                .map(CragMapper::toDTO);
    }

    public List<CragDTO> getAllCrags() {
        return cragRepository.findAll().stream()
                .map(CragMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CragDTO> getCragByCoordinates(Double lat, Double lon) {
        return cragRepository.findByLatAndLon(lat, lon)
                .map(CragMapper::toDTO);
    }

    public List<CragDTO> getCragsByName(String name) {
        return cragRepository.findByNameContainingIgnoreCase(name).stream()
                .map(CragMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<CragDTO> getCragsByCityOrPostalCode(String city, String postalCode) {
        return cragRepository.findByCityContainingIgnoreCaseOrPostalCodeContainingIgnoreCase(city, postalCode).stream()
                .map(CragMapper::toDTO)
                .collect(Collectors.toList());
    }



    public CragDTO update(Long id, CragDTO dto) {
        Crag crag = cragRepository.findById(id)
                .orElseThrow(() -> new CragNotFoundException("Site introuvable avec l'ID " + id));
        crag.setName(dto.getName());
        crag.setCity(dto.getCity());
        crag.setPostalCode(dto.getPostalCode());
        crag.setLat(dto.getLat());
        crag.setLon(dto.getLon());
        crag.setAltitude(dto.getAltitude());
        crag.setRockType(dto.getRockType());
        crag.setMinGrade(dto.getMinGrade());
        crag.setMaxGrade(dto.getMaxGrade());
        crag.setExposure(dto.getExposure());
        crag.setFavorableSeasons(dto.getFavorableSeasons());
        crag.setOrientations(dto.getOrientations());
        crag.setPhotoUrl(dto.getPhotoUrl());
        crag.setThumbnailUrl(dto.getThumbnailUrl());
        return CragMapper.toDTO(cragRepository.save(crag));
    }

    public void delete(Long id) {
        if (!cragRepository.existsById(id)) {
            throw new CragNotFoundException("Site d'escalade introuvable avec l'ID " + id);
        }
        cragRepository.deleteById(id);
    }
}