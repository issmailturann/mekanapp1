package com.mekanapp.userservice.dto;

import jakarta.validation.constraints.NotNull;

public record AccountCreateDto(
        @NotNull
        String firstName,
        @NotNull
        String lastName,
        @NotNull
        String username,
        @NotNull
        String password
) {
}
