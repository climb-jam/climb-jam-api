package com.gretacvld.climb_jam_api.dtos;

import com.gretacvld.climb_jam_api.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    private Long id;

    @NotBlank(message = "L'email est obligatoire.")
    @Email(message = "L'email doit être valide.")
    private String email;

    @NotBlank(message = "Le nom d'utilisateur est obligatoire.")
    private String username;

    private Role role;
    private Instant createdAt;

    private ProfileDTO profile;
}