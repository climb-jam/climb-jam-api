package com.gretacvld.climb_jam_api.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FriendshipDTO {

    @NotNull(message = "L'identifiant de l'utilisateur est obligatoire.")
    private Long userId;

    @NotNull(message = "L'identifiant de l'ami est obligatoire.")
    private Long friendId;

    private Instant createdAt;
}