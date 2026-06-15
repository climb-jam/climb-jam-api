package com.gretacvld.climb_jam_api.dtos;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterRequestDTO {

    @NotBlank(message = "L'e-mail ne peut pas être vide.")
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Le format de l'e-mail est invalide."
    )
    private String email;

    @NotBlank(message = "Le mot de passe ne peut pas être vide.")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{12,}$",
            message = "Le mot de passe doit contenir au moins 12 caractères, une lettre majuscule, une lettre minuscule, un chiffre et un caractère spécial."
    )
    private String password;

    @NotBlank(message = "Le nom d'utilisateur ne peut pas être vide.")
    private String username;

    @AssertTrue(message = "Vous devez accepter les conditions d'utilisation.")
    private Boolean termsAccepted;
}