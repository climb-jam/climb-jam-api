package com.gretacvld.climb_jam_api.dtos;

import com.gretacvld.climb_jam_api.enums.NotificationStatus;
import com.gretacvld.climb_jam_api.enums.NotificationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NotificationDTO {

    private Long id;

    @NotNull(message = "L'identifiant de l'utilisateur est obligatoire.")
    private Long userId;

    @NotNull(message = "Le type de notification est obligatoire.")
    private NotificationType type;

    @NotBlank(message = "Le contenu de la notification ne peut pas être vide.")
    private String content;

    @NotNull(message = "Le statut de la notification est obligatoire.")
    private NotificationStatus status;

    private Instant createdAt;
}