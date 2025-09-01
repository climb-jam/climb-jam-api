package com.gretacvld.climb_jam_api.dtos;

import com.gretacvld.climb_jam_api.enums.TargetType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentDTO {

    private Long id;

    @NotNull(message = "L'identifiant de l'utilisateur est obligatoire.")
    private Long userId;

    @NotNull(message = "Le type de cible est obligatoire.")
    private TargetType targetType;

    @NotNull(message = "L'identifiant de la cible est obligatoire.")
    private Long targetId;

    @NotBlank(message = "Le contenu du commentaire ne peut pas être vide.")
    private String content;

    private Instant createdAt;
}