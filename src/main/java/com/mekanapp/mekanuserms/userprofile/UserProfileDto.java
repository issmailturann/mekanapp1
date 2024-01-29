package com.mekanapp.mekanuserms.userprofile;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserProfileDto(
        UUID userId,
        String biography,
        String pleasures_and_hobbies,
        String preferred_places,
        LocalDateTime createdDate
) {
}
