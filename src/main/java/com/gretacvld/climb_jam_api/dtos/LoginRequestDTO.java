package com.gretacvld.climb_jam_api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginRequestDTO {

    @NotBlank(message = "L'e-mail ne peut pas être vide.")
    @Email(message = "Le format de l'e-mail est invalide.")
    private String email;

    @NotBlank(message = "Le mot de passe ne peut pas être vide.")
    private String password;
}