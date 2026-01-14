package com.gretacvld.climb_jam_api.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestDTO {

    @NotNull(message = "L'identifiant de l'expéditeur est obligatoire.")
    private Long senderId;

    @NotNull(message = "L'identifiant du destinataire est obligatoire.")
    private Long receiverId;
}