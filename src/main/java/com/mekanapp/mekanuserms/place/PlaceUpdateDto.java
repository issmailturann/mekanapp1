package com.mekanapp.mekanuserms.place;

import jakarta.validation.constraints.NotNull;

public record PlaceUpdateDto(

        @NotNull
        String placeName,
        @NotNull
        String placeAddress,
        @NotNull
        String placePhoneNumber

) {
}
