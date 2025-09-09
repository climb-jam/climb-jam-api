package com.gretacvld.climb_jam_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProfileDTO {

    private Long id;

    @NotNull(message = "L'identifiant de l'utilisateur est obligatoire.")
    private Long userId;

    private String avatarUrl;
    private String city;

    @NotBlank(message = "Le code postal ne peut pas être vide.")
    @Pattern(
            regexp = "\\d{5}",
            message = "Le code postal doit contenir 5 chiffres."
    )
    private String postalCode;
}