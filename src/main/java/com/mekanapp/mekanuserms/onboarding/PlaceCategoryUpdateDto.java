package com.mekanapp.mekanuserms.onboarding;

import jakarta.validation.constraints.NotNull;

public record PlaceCategoryUpdateDto(
        @NotNull
        String categoryName
) {
}
