package com.gretacvld.climb_jam_api.services;

import com.gretacvld.climb_jam_api.dtos.SessionDTO;
import com.gretacvld.climb_jam_api.entities.Crag;
import com.gretacvld.climb_jam_api.entities.Session;
import com.gretacvld.climb_jam_api.entities.User;
import com.gretacvld.climb_jam_api.exceptions.CragNotFoundException;
import com.gretacvld.climb_jam_api.exceptions.SessionNotFoundException;
import com.gretacvld.climb_jam_api.exceptions.UserNotFoundException;
import com.gretacvld.climb_jam_api.mappers.SessionMapper;
import com.gretacvld.climb_jam_api.repositories.CragRepository;
import com.gretacvld.climb_jam_api.repositories.SessionRepository;
import com.gretacvld.climb_jam_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CragRepository cragRepository;

    public List<SessionDTO> getAllSessions() {
        return sessionRepository.findAll().stream()
                .map(SessionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<SessionDTO> getSessionById(Long id) {
        return sessionRepository.findById(id).map(SessionMapper::toDTO);
    }

    public List<SessionDTO> getSessionsByUserId(Long userId) {
        return sessionRepository.findByUserId(userId).stream()
                .map(SessionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<SessionDTO> getSessionsByCragId(Long cragId) {
        return sessionRepository.findByCragId(cragId).stream()
                .map(SessionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SessionDTO create(SessionDTO dto) {
        User user = userRepository.findById(dto.getUser().getId())
                .orElseThrow(() -> new UserNotFoundException("Utilisateur introuvable"));
        Crag crag = cragRepository.findById(dto.getCrag().getId())
                .orElseThrow(() -> new CragNotFoundException("Site d'escalade introuvable"));
        Session session = SessionMapper.toEntity(dto);
        session.setUser(user);
        session.setCrag(crag);
        return SessionMapper.toDTO(sessionRepository.save(session));
    }

    public SessionDTO update(Long id, SessionDTO dto) {
        Session session = sessionRepository.findById(id)
                .orElseThrow(() -> new SessionNotFoundException("Session introuvable avec l'ID " + id));
        session.setDate(dto.getDate());
        return SessionMapper.toDTO(sessionRepository.save(session));
    }

    public void delete(Long id) {
        if (!sessionRepository.existsById(id)) {
            throw new SessionNotFoundException("Session introuvable avec l'ID " + id);
        }
        sessionRepository.deleteById(id);
    }
}