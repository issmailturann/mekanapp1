package com.mekanapp.mekanuserms.onboarding;

import jakarta.validation.constraints.NotNull;

public record PlaceCategoryCreateDto(
        @NotNull
        String categoryName
) {
}
