package com.gretacvld.climb_jam_api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponseDTO {

    private Long id;
    private String email;
    private String username;
    private Instant createdAt;
}