package com.mekanapp.userservice.account;

import jakarta.validation.constraints.NotNull;

public record AccountUpdateDto(
        @NotNull
        String firstName,
        @NotNull
        String lastName,
        @NotNull
        String password
) {
}
