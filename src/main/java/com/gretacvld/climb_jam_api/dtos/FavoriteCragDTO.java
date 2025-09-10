package com.gretacvld.climb_jam_api.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FavoriteCragDTO {

    private Long id;

    @NotNull(message = "L'utilisateur est obligatoire.")
    private UserDTO user;

    @NotNull(message = "Le site d'escalade est obligatoire.")
    private CragDTO crag;
}