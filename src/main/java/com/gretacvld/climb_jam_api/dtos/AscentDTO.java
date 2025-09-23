package com.gretacvld.climb_jam_api.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AscentDTO {

    private Long id;

    //@NotNull(message = "L'utilisateur est obligatoire.")
    private UserDTO user;

    @NotNull(message = "La voie est obligatoire.")
    private RouteDTO route;

    //@NotNull(message = "La session est obligatoire.")
    private SessionDTO session;

    @NotNull(message = "La date de l'ascension est obligatoire.")
    @PastOrPresent(message = "La date de l'ascension ne peut pas être dans le futur.")
    private LocalDate date;

    @NotBlank(message = "Le style d'ascension est obligatoire.")
    private String style;

    @Min(value = 1, message = "Le nombre d'essais doit être au minimum 1.")
    private Integer tries = 1;

    @Size(
            max = 1000,
            message = "Le commentaire ne doit pas dépasser 1000 caractères."
    )
    private String comment;
}