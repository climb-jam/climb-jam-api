package com.gretacvld.climb_jam_api.dtos;

import com.gretacvld.climb_jam_api.enums.ItemType;
import com.gretacvld.climb_jam_api.enums.LogAction;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LogDTO {

    private Long id;

    @NotNull(message = "L'identifiant de l'utilisateur est obligatoire.")
    private Long userId;

    @NotNull(message = "L'action est obligatoire.")
    private LogAction action;

    @NotNull(message = "Le type d'élément est obligatoire.")
    private ItemType itemType;

    @NotNull(message = "L'identifiant de l'élément est obligatoire.")
    private Long itemId;

    @Size(max = 1000, message = "Les détails ne doivent pas dépasser 1000 caractères.")
    private String details;

    private Instant createdAt;
}