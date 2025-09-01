package com.gretacvld.climb_jam_api.repositories;

import com.gretacvld.climb_jam_api.entities.FavoriteCrag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteCragRepository extends JpaRepository<FavoriteCrag, Long> {

    List<FavoriteCrag> findByUserId(Long userId);
}