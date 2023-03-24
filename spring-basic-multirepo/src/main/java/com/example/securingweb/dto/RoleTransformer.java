package com.example.securingweb.dto;

import com.example.securingweb.h2.Role;

import java.util.function.Function;

/**
 * Author: Nancy
 * Provides the mapping of entity with DTO
 * Provides the mapping of role and permissions
 */
public class RoleTransformer {

    public static final Function<Role, RoleDTO> ROLE_TO_DTO = (role) -> {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName(role.getUsername());
        roleDTO.setDescription(role.getRole());

        return roleDTO;
    };
}
