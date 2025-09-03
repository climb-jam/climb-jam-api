package com.gretacvld.climb_jam_api.repositories;

import com.gretacvld.climb_jam_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByEmail(String email);
    public boolean existsByEmail(String email);
    public Optional<User> findByUsername(String username);
    public boolean existsByUsername(String username);
}