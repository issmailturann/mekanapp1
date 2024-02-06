package com.mekanapp.mekanuserms.place;

import java.util.UUID;

public record PlaceDto(

        UUID id,
        String placeName,
        String placeAddress,
        String placePhoneNumber,
        String placeStatus

) {
}
