package com.gretacvld.climb_jam_api.services;

import com.gretacvld.climb_jam_api.dtos.CragDTO;
import com.gretacvld.climb_jam_api.mappers.CragMapper;
import com.gretacvld.climb_jam_api.repositories.CragRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CragService {

    @Autowired
    private CragRepository cragRepository;

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
}