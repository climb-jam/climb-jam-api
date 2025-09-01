package com.gretacvld.climb_jam_api.repositories;

import com.gretacvld.climb_jam_api.entities.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

    List<Friendship> findByUserId(Long userId);
    List<Friendship> findByFriendId(Long friendId);
}