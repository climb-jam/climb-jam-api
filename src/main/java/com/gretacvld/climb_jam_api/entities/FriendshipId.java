package com.gretacvld.climb_jam_api.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FriendshipId implements Serializable {
    private Long userId;
    private Long friendId;
}