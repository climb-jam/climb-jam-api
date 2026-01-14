package com.gretacvld.climb_jam_api.dtos;

import com.gretacvld.climb_jam_api.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminUserDTO {

    private Long id;
    private String email;
    private String username;
    private Role role;
}