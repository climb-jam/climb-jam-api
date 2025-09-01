package com.gretacvld.climb_jam_api.repositories;

import com.gretacvld.climb_jam_api.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findBySenderId(Long senderId);
    List<Request> findByReceiverId(Long receiverId);
}