package com.gretacvld.climb_jam_api.repositories;

import com.gretacvld.climb_jam_api.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {

    List<Log> findByUserId(Long userId);
}