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

    private Long id;

    @NotNull(message = "L'utilisateur est obligatoire.")
    private UserDTO user;

    @NotNull(message = "Le site d'escalade est obligatoire.")
    private CragDTO crag;

    @NotNull(message = "La date de la session est obligatoire.")
    @PastOrPresent(message = "La date de la session ne peut pas être dans le futur.")
    private LocalDate date;
}