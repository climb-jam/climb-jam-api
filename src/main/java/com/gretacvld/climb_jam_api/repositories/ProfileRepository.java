package com.gretacvld.climb_jam_api.repositories;

import com.gretacvld.climb_jam_api.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> findByUserUsername(String username);
}