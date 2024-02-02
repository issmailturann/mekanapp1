package com.mekanapp.mekanuserms.account;

import jakarta.validation.constraints.NotNull;

public record AccountLoginDto(
        @NotNull
        String username,
        @NotNull
        String password
) {
}
