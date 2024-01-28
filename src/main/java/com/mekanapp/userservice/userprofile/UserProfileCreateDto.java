package com.mekanapp.userservice.userprofile;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record UserProfileCreateDto(
        @NotNull
        UUID userId,
        @NotNull
        String biography,
        @NotNull
        String phoneNumber,
        @NotNull
        LocalDate dateOfBirth,
        @NotNull
        String gender,
        @NotNull
        String pleasures_and_hobbies,
        @NotNull
        String preferred_places
) {
}
