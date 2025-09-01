package com.gretacvld.climb_jam_api.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SessionDTO {

    @NotNull(message = "L'identifiant de l'utilisateur est obligatoire.")
    private Long userId;

    @NotNull(message = "L'identifiant du site d'escalade est obligatoire.")
    private Long cragId;

    @NotNull(message = "La date de la session est obligatoire.")
    @PastOrPresent(message = "La date de la session ne peut pas être dans le futur.")
    private LocalDate date;
}