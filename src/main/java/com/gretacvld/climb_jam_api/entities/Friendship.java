package com.gretacvld.climb_jam_api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Friendship {

    @EmbeddedId
    private FriendshipId id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @MapsId("userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "friend_id", nullable = false)
    @MapsId("friendId")
    private User friend;

    private Instant createdAt = Instant.now();
}