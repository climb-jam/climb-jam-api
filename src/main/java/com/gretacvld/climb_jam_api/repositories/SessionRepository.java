package com.gretacvld.climb_jam_api.repositories;

import com.gretacvld.climb_jam_api.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {

    List<Session> findByUserId(Long userId);
    List<Session> findByCragId(Long cragId);
}