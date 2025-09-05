package com.gretacvld.climb_jam_api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthResponseDTO {

    private UserResponseDTO user;
    private String token;
}