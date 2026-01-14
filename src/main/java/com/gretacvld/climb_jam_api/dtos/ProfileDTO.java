package com.gretacvld.climb_jam_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProfileDTO {

    private Long id;

    private String avatarUrl;
    private String city;

    @NotBlank(message = "Le code postal ne peut pas être vide.")
    @Size(min = 5, max = 5, message = "Le code postal doit contenir 5 caractères.")
    private String postalCode;
}