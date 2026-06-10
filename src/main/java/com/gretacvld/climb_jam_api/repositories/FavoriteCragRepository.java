package com.gretacvld.climb_jam_api.repositories;

import com.gretacvld.climb_jam_api.entities.FavoriteCrag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteCragRepository extends JpaRepository<FavoriteCrag, Long> {
    boolean existsByUserIdAndCragId(Long userId, Long cragId);
    void deleteByUserIdAndCragId(Long userId, Long cragId);
    Optional<FavoriteCrag> findByUserIdAndCragId(Long userId, Long cragId);
    List<FavoriteCrag> findByUserId(Long userId);
}