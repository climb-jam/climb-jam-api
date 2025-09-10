package com.gretacvld.climb_jam_api.services;

import com.gretacvld.climb_jam_api.dtos.AscentDTO;
import com.gretacvld.climb_jam_api.entities.Ascent;
import com.gretacvld.climb_jam_api.entities.Route;
import com.gretacvld.climb_jam_api.entities.Session;
import com.gretacvld.climb_jam_api.entities.User;
import com.gretacvld.climb_jam_api.exceptions.AscentNotFoundException;
import com.gretacvld.climb_jam_api.exceptions.RouteNotFoundException;
import com.gretacvld.climb_jam_api.exceptions.SessionNotFoundException;
import com.gretacvld.climb_jam_api.exceptions.UserNotFoundException;
import com.gretacvld.climb_jam_api.mappers.AscentMapper;
import com.gretacvld.climb_jam_api.repositories.AscentRepository;
import com.gretacvld.climb_jam_api.repositories.RouteRepository;
import com.gretacvld.climb_jam_api.repositories.SessionRepository;
import com.gretacvld.climb_jam_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AscentService {

    @Autowired
    private AscentRepository ascentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private SessionRepository sessionRepository;

    public List<AscentDTO> getAllAscents() {
        return ascentRepository.findAll().stream()
                .map(AscentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AscentDTO> getAscentById(Long id) {
        return ascentRepository.findById(id).map(AscentMapper::toDTO);
    }

    public List<AscentDTO> getAscentsByUserId(Long userId) {
        return ascentRepository.findByUserId(userId).stream()
                .map(AscentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<AscentDTO> getAscentsByRouteId(Long routeId) {
        return ascentRepository.findByRouteId(routeId).stream()
                .map(AscentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<AscentDTO> getAscentsBySessionId(Long sessionId) {
        return ascentRepository.findBySessionId(sessionId).stream()
                .map(AscentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AscentDTO create(AscentDTO dto) {
        User user = userRepository.findById(dto.getUser().getId())
                .orElseThrow(() -> new UserNotFoundException("Utilisateur introuvable"));
        Route route = routeRepository.findById(dto.getRoute().getId())
                .orElseThrow(() -> new RouteNotFoundException("Voie introuvable"));
        Session session = sessionRepository.findById(dto.getSession().getId())
                .orElseThrow(() -> new SessionNotFoundException("Session introuvable"));
        Ascent ascent = AscentMapper.toEntity(dto);
        ascent.setUser(user);
        ascent.setRoute(route);
        ascent.setSession(session);
        return AscentMapper.toDTO(ascentRepository.save(ascent));
    }

    public void delete(Long id) {
        if (!ascentRepository.existsById(id)) {
            throw new AscentNotFoundException("Croix introuvable avec l'ID " + id);
        }
        ascentRepository.deleteById(id);
    }

    public AscentDTO commentOnAscent(Long id, String comment) {
        Ascent ascent = ascentRepository.findById(id)
                .orElseThrow(() -> new AscentNotFoundException("Croix introuvable avec l'ID " + id));
        ascent.setComment(comment);
        return AscentMapper.toDTO(ascentRepository.save(ascent));
    }

    public AscentDTO updateComment(Long id, String newComment) {
        return commentOnAscent(id, newComment);
    }

    public AscentDTO deleteComment(Long id) {
        return commentOnAscent(id, null);
    }
}